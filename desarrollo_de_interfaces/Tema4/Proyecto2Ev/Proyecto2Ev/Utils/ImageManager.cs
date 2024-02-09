using System;
using System.Collections.Generic;
using System.Drawing;
using System.IO;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2Ev.Utils
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que gestiona la carga de imágenes desde URL o ruta local.
=======
    /// Clase utilitaria que proporciona métodos para cargar imágenes desde URL o rutas de archivo en una aplicación.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class ImageManager
    {
        /// <summary>
<<<<<<< HEAD
        /// Carga una imagen desde una URL proporcionada.
        /// </summary>
        /// <param name="imageUrl">La URL de la imagen que se va a cargar.</param>
=======
        /// Carga una imagen desde una URL en línea.
        /// </summary>
        /// <param name="imageUrl">La URL de la imagen que se desea cargar.</param>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// <returns>La imagen cargada desde la URL o una imagen de respaldo en caso de error.</returns>
        public static async Task<Image> FromURL(string imageUrl)
        {
            try
            {
                using (HttpClient client = new HttpClient())
                using (Stream stream = await client.GetStreamAsync(new Uri(imageUrl)))
                {
                    // Cargar la imagen desde la secuencia obtenida de la URL
                    return Image.FromStream(stream);
                }
            }
            catch (Exception e)
            {
                // En caso de error, carga una imagen de respaldo
                return FromPath("./Assets/img/logoPezinvertido.png");
            }
        }

        /// <summary>
<<<<<<< HEAD
        /// Carga una imagen desde una ruta local en el sistema.
        /// </summary>
        /// <param name="imagePath">La ruta de la imagen que se va a cargar.</param>
        /// <returns>La imagen cargada desde la ruta especificada.</returns>
=======
        /// Carga una imagen desde una ruta de archivo local.
        /// </summary>
        /// <param name="imagePath">La ruta de archivo de la imagen que se desea cargar.</param>
        /// <returns>La imagen cargada desde la ruta de archivo local.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static Image FromPath(string imagePath)
        {
            // Cargar la imagen desde la ruta local
            return Image.FromFile(imagePath);
        }
    }
}