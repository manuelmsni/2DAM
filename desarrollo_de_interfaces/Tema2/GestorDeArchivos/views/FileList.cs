using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using GestorDeArchivos.assets.config;
using GestorDeArchivos.util;
using Microsoft.VisualBasic;
using Constants = GestorDeArchivos.assets.config.Constants;

namespace GestorDeArchivos
{
    public partial class FileList : Form
    {
        private DirectoryInfo Di;
        private string PathToDirectory;
        private Button LastClicked;
        private long Ticks;
        public FileList()
        {
            InitializeComponent();
            InitCustom();
        }

        /* * * * * * * * * *
         *  Inicialización * ------------------------------------------------------------------
         * * * * * * * * * */

        /// <summary>
        /// Si no detecta el directorio objetivo, declarado en la clase de constantes, lo crea.
        /// Recoje la información de dicho directorio en una variable global.
        /// Llama a los métodos que se encargan de la inicialización de los elementos que se crean de
        /// forma dinámica.
        /// </summary>
        private void InitCustom()
        {
            PathToDirectory = Constants.PathToDirectory;
            Directory.CreateDirectory(PathToDirectory);
            Paint();
        }

        /// <summary>
        /// Obtiene la estructura de directorios y archivos dentro del directorio objetivo y
        /// por cada uno llama al respectivo método que se encarga de crear un botón que representa
        /// dicho directorio o archivo.
        /// </summary>
        private void Paint()
        {
            Di = new DirectoryInfo(PathToDirectory);
            if (PathToDirectory == Constants.PathToDirectory) goBack.Enabled = false;
            else goBack.Enabled = true;
            url.Text = $"Path: {PathToDirectory}";
            DirectoryInfo[] directories = Di.GetDirectories("*", SearchOption.TopDirectoryOnly);
            if (directories.Length > 0) directories.ToList().ForEach(fi => AddDirectory(fi));
            FileInfo[] files = Di.GetFiles("*", SearchOption.TopDirectoryOnly);
            if (files.Length > 0) files.ToList().ForEach(fi => AddFile(fi));
        }

        /// <summary>
        /// Elimina el contenido de la ventana y lo genera de nuevo con los directorios y archivos actualizados.
        /// </summary>
        private void Repaint()
        {
            flowLayoutPanel1.Controls.Clear();
            Paint();
        }

        /// <summary>
        /// Llama al método que devuelve un botón, con los datos del archivo y le establece la imagen
        /// correspondiente a un archivo.
        /// </summary>
        /// <param name="file">La información del archivo.</param>
        private void AddFile(FileInfo file)
        {
            Button temp = CreateCustomButton(file.Name);
            temp.Image = System.Drawing.Image.FromFile(Constants.PathToFileImage);
            temp.Click += File_Click;
        }
        /// <summary>
        /// Llama al método que devuelve un botón, con los datos del directorio y le establece la imagen
        /// correspondiente a un directorio.
        /// </summary>
        /// <param name="file">La información del directorio.</param>
        private void AddDirectory(DirectoryInfo file)
        {
            Button temp = CreateCustomButton(file.Name);
            temp.Image = System.Drawing.Image.FromFile(Constants.PathToDirectoryImage);
            temp.Click += Directory_Click;
        }
        /// <summary>
        /// Crea y devuelve un botón personalizado con el texto que se le proporciona.
        /// </summary>
        /// <param name="file">
        /// El texto que se asignará al botón.
        /// El texto es formateado mediante el método Format de la clase ButtonNameFormatter.
        /// </param>
        private Button CreateCustomButton(String name)
        {
            Button button1 = new Button();
            button1.Name = name;
            button1.Text = ButtonNameFormatter.Format(name);
            button1.BackgroundImageLayout = ImageLayout.Stretch;
            button1.Cursor = Cursors.Hand;
            button1.FlatAppearance.BorderSize = 0;
            button1.FlatStyle = FlatStyle.Flat;
            button1.ImageAlign = ContentAlignment.TopCenter;
            button1.Margin = new Padding(10, 10, 0, 0);
            button1.MinimumSize = new Size(72, 72);
            button1.TabIndex = 0;
            button1.TextAlign = ContentAlignment.BottomCenter;
            flowLayoutPanel1.Controls.Add(button1);
            button1.MouseDown += Button_RightClick;
            return button1;
        }

        /* * * * * *
         * Eventos * ----------------------------------------------------------------------------
         * * * * * */

        /// <summary>
        /// Maneja el evento de clic en el flowPanel.
        /// Gestiona la apertura del menú contextual en la posición del cursor
        /// si el click ha sido con el botón derecho.
        /// </summary>
        /// <param name="sender">El objeto que desencadenó el evento.</param>
        /// <param name="e">Los argumentos del evento.</param>
        private void OpenRightClickMenu(object sender, EventArgs e)
        {
            MouseEventArgs casted = e as MouseEventArgs;
            if (casted.Button == MouseButtons.Right) menuClickDerecho.Show(PointToScreen(casted.Location));
        }
        /// <summary>
        /// Maneja el evento de clic en el botón crear carpeta del menú contextual.
        /// Gestiona la apertura del formulario NameForm, que solicitará un string,
        /// pasandole por parámetros el texto correspondiente para la solicitud de datos del
        /// nombre de la carpeta.
        /// </summary>
        /// <param name="sender">El objeto que desencadenó el evento.</param>
        /// <param name="e">Los argumentos del evento.</param>
        private void OpenCreateDirectoryWindow(object sender, EventArgs e)
        {
            string nombre = StringForm.GetName("Nombre de la carpeta:", "Crear carpeta");
            if (string.IsNullOrEmpty(nombre)) return;
            if (DirectoryManager.CreateDirectory(Path.Combine(PathToDirectory, nombre)))
                Repaint();
            else
                MessageBox.Show($"Ese nombre ya está siendo utilizado", "No se puede crear la carpeta", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        /// <summary>
        /// Maneja el evento de clic en el botón crear archivo del menú contextual.
        /// Gestiona la apertura del formulario NameForm, que solicitará un string,
        /// pasandole por parámetros el texto correspondiente para la solicitud de datos del
        /// nombre del archivo.
        /// </summary>
        /// <param name="sender">El objeto que desencadenó el evento.</param>
        /// <param name="e">Los argumentos del evento.</param>
        private void OpenCreateFileWindow(object sender, EventArgs e)
        {
            string nombre = StringForm.GetName("Nombre del archivo:", "Crear archivo");
            if (string.IsNullOrEmpty(nombre)) return;
            if(FileManager.CreateFile(Path.Combine(PathToDirectory, nombre)))
                Repaint();
            else
                MessageBox.Show($"Ese nombre ya está siendo utilizado", "No se puede crear el archivo", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }

        private void Directory_Click(object sender, EventArgs e)
        {
            PathToDirectory = Path.Combine(PathToDirectory, (sender as Button).Name);
            Repaint();
        }

        private void File_Click(object sender, EventArgs e)
        {
            Button clicked = sender as Button;
            if (!CheckDoubleClick(clicked)) return;
            MainView.GetInstance().LoadFile(Path.Combine(PathToDirectory, clicked.Name));
            this.Close();
        }

        private void GoBack_Click(object sender, EventArgs e)
        {
            PathToDirectory = Path.GetDirectoryName(PathToDirectory) ?? PathToDirectory;
            Repaint();
        }

        private void Button_RightClick(object sender, MouseEventArgs e)
        {
            if (e.Button != MouseButtons.Right) return;
            LastClicked = sender as Button;
            if (sender as Button == null) return;
            int x = e.Location.X + LastClicked.Location.X;
            int y = e.Location.Y + LastClicked.Location.Y;
            MenuBorrar.Show(PointToScreen(new Point(x, y)));
        }

        private void Delete_Click(object sender, EventArgs e)
        {
            if (LastClicked == null) return;
            string path = Path.Combine(PathToDirectory, LastClicked.Text);
            PathManager.DeleteValidating(path);
            Repaint();
        }

        private bool CheckDoubleClick(Button clicked)
        {
            long currentTicks = DateTime.Now.Ticks;
            if (clicked != LastClicked || (clicked == LastClicked && currentTicks > (Ticks + Constants.DoubleClickThreshold)))
            {
                Ticks = currentTicks;
                LastClicked = clicked;
                return false;
            }
            Ticks = currentTicks;
            LastClicked = clicked;
            return true;
        }
    }
}
