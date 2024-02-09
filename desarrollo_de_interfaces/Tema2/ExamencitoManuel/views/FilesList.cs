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

namespace ExamencitoManuel.views
{
    public partial class FilesList : Form
    {
        public FilesList()
        {
            InitializeComponent();
        }
        private void InitCustom()
        {
            MainView.GetInstance().Archivos.ForEach(f => InitComparer(f));
        }
        private void InitComparer(ArchivoAComparar a)
        {

        }
    }
}
