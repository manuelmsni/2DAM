using ExamencitoManuel.utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamencitoManuel.models
{
    public class ArchivoAComparar
    {
        public string Path {  get; set; }
        public string Name { get; set; }
        public string Content { get; set; }
        public ArchivoAComparar() { }
        public ArchivoAComparar(string path, string name)
        {
            Path = path;
            Name = name;
            Read();
        }
        public string ToString()
        {
            return Name;
        }
        private void Read()
        {
            Content = FileManager.ReadFile(Path) ?? "";
        }
    }
}
