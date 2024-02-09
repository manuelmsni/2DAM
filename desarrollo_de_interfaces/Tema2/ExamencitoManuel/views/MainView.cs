using ExamencitoManuel.clients;
using ExamencitoManuel.models;
using ExamencitoManuel.utils;
using Google.Protobuf;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ExamencitoManuel.views
{
    public partial class MainView : Form
    {
        public static MainView Instance { get; private set; }
        public static MainView GetInstance()
        {
            if (Instance == null) Instance = new MainView();
            return Instance;
        }
        private MainView()
        {
            InitializeComponent();
            InitCustom();
        }
        private void InitCustom()
        {
            InitComboBox();
        }
        public List<ArchivoAComparar> Archivos;
        public void InitComboBox()
        {
            DirectoryInfo Di = new DirectoryInfo(Constants.PathToDirectory);
            FileInfo[] files = Di.GetFiles("*", SearchOption.TopDirectoryOnly);
            Archivos = new List<ArchivoAComparar>();
            foreach (FileInfo file in files)
            {
                ArchivoAComparar temp = new ArchivoAComparar(file.FullName, file.Name);
                Archivos.Add(temp);
                comboBox1.Items.Add(temp);
                comboBox2.Items.Add(temp);
            }
            comboBox1.SelectedIndexChanged += SeleccionadoPrimerCombo;
            comboBox2.SelectedIndexChanged += SeleccionadoSegundoCombo;
        }



        private void SeleccionadoPrimerCombo(object? sender, EventArgs e)
        {
            richTextBox1.Text = ((ArchivoAComparar)comboBox1.SelectedItem).Content;
        }

        private void SeleccionadoSegundoCombo(object? sender, EventArgs e)
        {
            richTextBox2.Text = ((ArchivoAComparar)comboBox2.SelectedItem).Content;
        }

        private async void Click_PrimerBoton(object sender, EventArgs e)
        {
            label1.Text = $"{await HttpJsonClient.PostMethod(richTextBox1.Text, richTextBox2.Text)}%";
        }

        private void Click_SegundoBoton(object sender, EventArgs e)
        {
            richTextBox1.Text = string.Empty;
            richTextBox2.Text = string.Empty;
            label1.Text = string.Empty;
        }

        private void Click_Admin(object sender, EventArgs e)
        {
            AdminView.GetInstance().ShowDialog();
        }
    }
}
