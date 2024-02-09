using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GestorDeArchivos.util
{
    internal class PathManager
    {
        public const int INT_NOT_EXIST_VALUE = 0;
        public const int INT_FILE_VALUE = 1;
        public const int INT_DIRECTORY_VALUE = 2;
        public static bool CheckPath(string path)
        {
            if (path == null)
            {
                MessageBox.Show("¡No se ha especificado una ruta!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
                return false;
            }
            return true;
        }

        public static int GetFileOrDirectory(string path)
        {
            if (!CheckPath(path)) return INT_NOT_EXIST_VALUE;

            if (File.Exists(path)) return INT_FILE_VALUE;

            if(Directory.Exists(path)) return INT_DIRECTORY_VALUE;

            MessageBox.Show("¡No hay nada en la ruta especificada!", "Error", MessageBoxButtons.OK, MessageBoxIcon.Error);
            return INT_NOT_EXIST_VALUE;
        }

        public static void DeleteValidating(String path)
        {
            switch (GetFileOrDirectory(path))
            {
                case INT_NOT_EXIST_VALUE:
                    break;
                case INT_FILE_VALUE:
                    FileManager.DeleteFile(path);
                    break;
                case INT_DIRECTORY_VALUE:
                    DirectoryManager.DeleteDirectory(path);
                    break;
            }
        }
    }
}
