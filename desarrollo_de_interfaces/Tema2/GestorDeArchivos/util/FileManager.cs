using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Reflection.Metadata.Ecma335;
using System.Security.Policy;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using static System.Net.Mime.MediaTypeNames;

namespace GestorDeArchivos.util
{
    internal class FileManager
    {
        public static int? SaveFile(string path, string text)
        {
            try
            {
                using (StreamWriter sw = new StreamWriter(path))
                {
                    sw.Write(text);
                }
                MessageBox.Show($"Contenido guardado en el archivo: {path}", "Guardado correctamente", MessageBoxButtons.OK, MessageBoxIcon.Information);
                return text.GetHashCode();
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al guardar el archivo: {path}\n{ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return null;
        }
        public static string LoadFile(string path)
        {
            try
            {
                using (StreamReader sr = new StreamReader(path))
                {
                    return sr.ReadToEnd();
                }
            }
            catch (Exception ex)
            {
                MessageBox.Show($"Error al leer el archivo: {ex.Message}", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            }
            return null;
        }
        public static void DeleteFile(string path)
        {
            if (!MainView.GetInstance().AskForConfirmation($"Se eliminará el archivo: {path} \n¿Deseas borrarlo?  :(")) return;
            File.Delete(path);
            MessageBox.Show($"Se ha eliminado el archivo {path}", "Eliminado correctamente", MessageBoxButtons.OK, MessageBoxIcon.Information);
        }
        /// <summary>
        /// Crea un archivo en la ruta especificada dentro del directorio base si el archivo no existe.
        /// </summary>
        /// <param name="nombre">Nombre del archivo a crear.</param>
        public static bool CreateFile(string ruta)
        {
            if (ruta == null) return false;
            if (ruta == string.Empty || File.Exists(ruta) || Directory.Exists(ruta)) return false;
            DirectoryManager.CreateDirectory(Path.GetDirectoryName(ruta));
            FileStream fs;
            if ((fs = File.Create(ruta)) != null) fs.Close();
            return true;
        }
    }
}
