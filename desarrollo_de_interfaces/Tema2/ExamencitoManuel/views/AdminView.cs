using ExamencitoManuel.components;
using ExamencitoManuel.dao;
using ExamencitoManuel.models;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Windows.Forms.VisualStyles.VisualStyleElement;

namespace ExamencitoManuel.views
{
    public partial class AdminView : Form
    {
        public static AdminView Instance { get; private set; }
        public static AdminView GetInstance()
        {
            if (Instance == null) Instance = new AdminView();
            return Instance;
        }
        private AdminView()
        {
            InitializeComponent();
            InitCustom();
        }
        private void InitCustom()
        {
        }

        private async void button1_Click(object sender, EventArgs e)
        {
            Usuario temp = new Usuario()
            {
                Name = textBox1.Text,
                Pass = textBox2.Text,
                Id = 0
            };
            DAOUser dao = new DAOUser();
            int id = dao.SelectObject(temp);
            if(id > 0) InitFileForm();
        }

        private void InitFileForm()
        {
            Container.Controls.Clear();
            Container.Controls.Add(new LoginCustom());
            FilesList fl = new FilesList();
            fl.ShowDialog();
        }

    }
}
