using GestorDeArchivos.assets.config;
using GestorDeArchivos.util;
using System.IO;
using System.Windows.Forms;
using static System.Net.Mime.MediaTypeNames;

namespace GestorDeArchivos
{
    public partial class MainView : Form
    {
        public static MainView Instance { get; private set; }

        private string CurrentFile { get; set; }

        private int? hash;

        private MainView()
        {
            InitializeComponent();
            hash = richTextBox1.Text.GetHashCode();
        }

        public static MainView GetInstance()
        {
            if (Instance == null) Instance = new MainView();
            return Instance;
        }

        private bool CheckFileCanBeClosed()
        {
            if (richTextBox1.Text.GetHashCode() == hash) return true;
            if (AskForConfirmation("El archivo actual no se ha guardado ¿Deseas guardarlo?"))
            {
                if(!SaveFile()) return false;
            }
            return true;
        }

        public bool AskForConfirmation(string messaje)
        {
            if (MessageBox.Show(messaje, "Confirmación", MessageBoxButtons.YesNo, MessageBoxIcon.Question) == DialogResult.Yes) return true;
            return false;
        }

        private void NewFile()
        {
            CheckFileCanBeClosed();
            Text = "Nuevo archivo";
            CurrentFile = null;
            richTextBox1.Text = string.Empty;
            hash = richTextBox1.Text.GetHashCode();
        }

        public void LoadFile(string path)
        {
            if (!File.Exists(path)) return;
            string text = FileManager.LoadFile(path);
            if (text == null) return;
            Text = Path.GetFileName(path);
            CurrentFile = path;
            richTextBox1.Text = text;
            hash = text.GetHashCode();
        }

        private bool SaveFile()
        {
            if (CurrentFile == null)
            {
                String nombre = StringForm.GetName("Nombre del archivo:", "Crear archivo");
                if (string.IsNullOrEmpty(nombre)) return false;
                string filePath = Path.Combine(Constants.PathToDirectory, nombre);
                if (!FileManager.CreateFile(filePath))
                {
                    MessageBox.Show($"Ya existe un elemento con ese nombre", "No se ha podido crear el archivo", MessageBoxButtons.OK, MessageBoxIcon.Information);
                    return false;
                }
                CurrentFile = filePath;
                Text = nombre;
            }
            hash = FileManager.SaveFile(CurrentFile, richTextBox1.Text);
            return true;
        }

        /// <summary>
        /// Maneja el evento Click del elemento de menú "About".
        /// Abre el formulario About.
        /// </summary>
        /// <param name="sender">Objeto que generó el evento.</param>
        /// <param name="e">Argumentos del evento.</param>
        private void About_Click(object sender, EventArgs e)
        {
            About a = new About();
            a.ShowDialog();
        }

        /// <summary>
        /// Maneja el evento Click del elemento de menú "File > Open".
        /// Abre el formulario FileList.
        /// </summary>
        /// <param name="sender">Objeto que generó el evento.</param>
        /// <param name="e">Argumentos del evento.</param>
        private void Open_Item_Click(object sender, EventArgs e)
        {
            if(!CheckFileCanBeClosed()) return;
            FileList fl = new FileList();
            fl.ShowDialog();
        }

        private void Save_Item_Click(object sender, EventArgs e)
        {
            SaveFile();
        }

        private void NewFile_Item_Click(object sender, EventArgs e)
        {
            NewFile();
        }

        private void Delete_Item_Click(object sender, EventArgs e)
        {
            FileManager.DeleteFile(CurrentFile);
        }

        private void MainView_FormClosing(object sender, FormClosingEventArgs e)
        {
            if(!CheckFileCanBeClosed()) e.Cancel = true;
        }
    }
}