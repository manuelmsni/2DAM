using MySql.Data.MySqlClient;
using Proyecto2Ev.Utils;
using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Docker.DotNet;
using Docker.DotNet.Models;

namespace Proyecto2Ev.DAO
{
    /// <summary>
<<<<<<< HEAD
    /// Clase encargada de la gestión de la base de datos, incluyendo la verificación de su existencia, la creación de la base de datos y tablas, 
    /// así como la administración de un contenedor Docker para la base de datos MySQL.
=======
    /// Clase que gestiona la base de datos y el contenedor Docker para la aplicación.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class DatabaseManager
    {
        /// <summary>
<<<<<<< HEAD
        /// Gestiona las excepciones relacionadas con la base de datos de forma asíncrona, verificando su existencia y la existencia de la tabla. 
        /// Ofrece la opción de crear la base de datos y/o la tabla en caso de que no existan.
=======
        /// Gestiona excepciones relacionadas con la base de datos.
        /// Comprueba si la base de datos y la tabla existen, y da la opción de crearlas si no existen.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static async Task ManageDatabaseExceptionsAsync()
        {
            if (!CheckDatabase())
            {
                MessageManager.ShowAlert("Error", "La base de datos no existe.");
                if (MessageManager.AskForConfirmation("¿Desea crear la base de datos?"))
                    DatabaseManager.CreateDatabase();
            }
            if (!CheckTable())
            {
                MessageManager.ShowAlert("Error", "La tabla no existe.");
                if (MessageManager.AskForConfirmation("¿Desea crear la tabla?"))
                    DatabaseManager.CreateTable();
            }
        }

        /// <summary>
<<<<<<< HEAD
        /// Verifica si el contenedor Docker de MySQL está en ejecución.
        /// </summary>
        /// <returns>True si el contenedor está en ejecución, False en caso contrario.</returns>
=======
        /// Comprueba si el contenedor Docker está en ejecución.
        /// </summary>
        /// <returns>true si el contenedor está en ejecución, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static async Task<bool> IsContainerRunning()
        {
            using (var client = new DockerClientConfiguration(new Uri("npipe://./pipe/docker_engine")).CreateClient())
            {
                try
                {
                    var container = await client.Containers.InspectContainerAsync(Constants.CONTAINER_NAME);
                    return container.State.Running;
                }
                catch (Docker.DotNet.DockerContainerNotFoundException)
                {
                    // El contenedor no existe
                    MessageManager.ShowAlert("Error", "El contenedor no existe.");
                    if (MessageManager.AskForConfirmation("¿Desea crear el contenedor?"))
                    {
                        await CreateContainer();

                        var container = await client.Containers.InspectContainerAsync(Constants.CONTAINER_NAME);
                        return container.State.Running;
                    }
                }
            }
            return false;
        }

        /// <summary>
<<<<<<< HEAD
        /// Verifica la existencia de la base de datos MySQL.
        /// </summary>
        /// <returns>True si la base de datos existe, False en caso contrario.</returns>
=======
        /// Comprueba si la base de datos existe.
        /// </summary>
        /// <returns>true si la base de datos existe, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static bool CheckDatabase()
        {
            // Crear la conexión a MySQL
            using (MySqlConnection connection = new MySqlConnection(Constants.SERVER_STRING))
            {
                try
                {
                    // Abrir la conexión
                    connection.Open();
                    using (MySqlCommand command = new MySqlCommand(Constants.USE_DATABASE, connection))
                    {
                        command.ExecuteNonQuery();
                    }
                }
                catch (MySqlException e)
                {
                    return false;
                }
            }
            return true;
        }
<<<<<<< HEAD

        /// <summary>
        /// Verifica la existencia de la tabla en la base de datos MySQL.
        /// </summary>
        /// <returns>True si la tabla existe, False en caso contrario.</returns>
=======
        /// <summary>
        /// Comprueba si la tabla existe en la base de datos.
        /// </summary>
        /// <returns>true si la tabla existe, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static bool CheckTable()
        {
            // Crear la conexión a MySQL
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                try
                {
                    // Abrir la conexión
                    connection.Open();
                    using (MySqlCommand command = new MySqlCommand($"SELECT COUNT(*) FROM {Constants.TABLE_NAME}", connection))
                    {
                        command.ExecuteNonQuery();
                    }
                }
                catch (MySqlException e)
                {
                    return false;
                }
            }
            return true;
        }
<<<<<<< HEAD

        /// <summary>
        /// Inicia el contenedor Docker de MySQL.
=======
        /// <summary>
        /// Inicia el contenedor Docker para la base de datos MySQL.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static void StartContainer()
        {
            using (Process process = new Process())
            {
                process.StartInfo.FileName = "docker";
                process.StartInfo.Arguments = $"start {Constants.CONTAINER_NAME}";
                process.StartInfo.WindowStyle = ProcessWindowStyle.Normal;
                process.StartInfo.UseShellExecute = false;
                process.StartInfo.CreateNoWindow = true;
                process.StartInfo.RedirectStandardOutput = true;
                process.StartInfo.RedirectStandardError = true;

                process.OutputDataReceived += (sender, e) => Console.WriteLine("Output: " + e.Data);
                process.ErrorDataReceived += (sender, e) => Console.WriteLine("Error: " + e.Data);

                try
                {
                    process.Start();
                    process.BeginOutputReadLine();
                    process.BeginErrorReadLine();
                    process.WaitForExit();
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Error: " + ex.Message);
                    return;
                }
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Crea la base de datos MySQL con la configuración especificada.
=======
        /// <summary>
        /// Crea la base de datos MySQL.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static void CreateDatabase()
        {
            // Cadena de conexión a la base de datos MySQL
            string connectionString = "server=localhost;" +
                                      "port=6969;" +
                                      "uid=root;" +
                                      "pwd=docker;";

            // Crear la conexión a MySQL
            using (MySqlConnection connection = new MySqlConnection(connectionString))
            {
                try
                {
                    // Abrir la conexión
                    connection.Open();

                    // Crear el comando SQL para crear la base de datos
                    using (MySqlCommand command = new MySqlCommand(Constants.DATABASE_CREATION, connection))
                    {
                        // Ejecutar la consulta SQL para crear la base de datos
                        command.ExecuteNonQuery();
<<<<<<< HEAD
                        MessageManager.ShowMessaje("Creada base de datos", "La base de datos se ha creado correctamente.");
=======
                        MessageManager.ShowMessage("Creada base de datos","La base de datos se ha creado correctamente.");
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
                    }

                }
                catch (Exception ex)
                {
                    ErrorManager.Register(ex);
                }
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Crea la tabla en la base de datos MySQL con la configuración especificada.
=======
        /// <summary>
        /// Crea la tabla en la base de datos MySQL.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static void CreateTable()
        {
            // Crear la conexión a MySQL
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                try
                {
                    // Abrir la conexión
                    connection.Open();

                    // Crear el comando SQL para crear la base de datos
                    using (MySqlCommand command = new MySqlCommand(Constants.TABLE_CREATION, connection))
                    {
                        // Ejecutar la consulta SQL para crear la base de datos
                        command.ExecuteNonQuery();
<<<<<<< HEAD
                        MessageManager.ShowMessaje("Creada tabla", "La tabla se ha creado correctamente.");
=======
                        MessageManager.ShowMessage("Creada tabla","La tabla se ha creado correctamente.");
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
                    }
                }
                catch (Exception ex)
                {
                    ErrorManager.Register(ex);
                }
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Inserta datos de prueba en la tabla 'Pet' de la base de datos MySQL.
=======
        /// <summary>
        /// Inserta datos de prueba en la tabla.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public static void InsertTestData()
        {
            // Script SQL para insertar las 20 mascotas de prueba
            string insertScript = @"
                    INSERT INTO `Pet` (`id`, `name`, `family`, `specie`, `price`, `visited`, `picture`, `birth`) VALUES
                    ('178254f1-7143-492c-be8f-fa7b0798c038', 'Escorpión español', 'Arácnido', 'Buthus occitanus', 25, 0, 'https://i0.wp.com/elguadarramista.com/wp-content/uploads/2019/12/800px-common_yellow_scorpion_buthus_occitanus_36043322670.jpg?ssl=1','2024-01-24'),
                    ('1819e553-59cc-4425-b952-64c0983a0cd6', 'Papagayo australiano', 'Ave', 'Alisterus scapularis', 30, 0, 'https://as2.ftcdn.net/v2/jpg/03/83/17/59/1000_F_383175909_Bj1TO6TjUlBBC44nG41cVuBpS0Uj1Ng2.jpg', '2018-01-24'),
                    ('1aa23a78-4779-4b9c-a590-7bebe53a588f', 'Gato naranja', 'Felino', 'Felis catus', 50, 0, 'https://www.infobae.com/new-resizer/AR6VnM1fN5vCKKIhEEc--r7GbWY=/992x1488/filters:format(webp):quality(85)/cloudfront-us-east-1.images.arcpublishing.com/infobae/VCVWSMNYEFDCXADXEIP7JZXIXY.jpg', '2016-01-24'),
                    ('2d88954a-03a0-4da1-9ac8-8189a74d9871', 'Husky', 'Canino', 'Canis lupus familiaris', 80, 0, 'https://i.pinimg.com/236x/6b/fc/54/6bfc54461c1d637fafae750ca3f3abb5.jpg', '2012-01-24'),
                    ('360bd63b-d27a-44c1-a286-3a1aafe371d2', 'Tortuga de orejas rojas', 'Reptil', 'Trachemys scripta elegans', 40, 0, 'https://tropicalnaturalhistory.files.wordpress.com/2019/08/trachemys-scripta-elegans-plastron-cherry-mischevious-via-pintrest.jpg', '2019-01-24'),
                    ('3842523d-0d7d-4016-a376-5fb9dc7d1e21', 'Hamster dorado', 'Roedor', 'Mesocricetus auratus', 20, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/9/98/Goldhamster_terrarium.jpg/230px-Goldhamster_terrarium.jpg', '2020-01-24'),
                    ('4b1a94be-a019-4501-a2ab-5b5275f1170c', 'Iguana verde', 'Reptil', 'Iguana iguana', 60, 0, 'https://img.freepik.com/foto-gratis/primer-plano-iguana-verde-primer-plano-animal-rama_488145-3329.jpg', '2012-01-24'),
                    ('50b1c252-49df-4f6e-aa87-7cfa8e92a51e', 'Canario amarillo', 'Ave', 'Serinus canaria', 25, 0, 'https://www.orniplus.com/blog/wp-content/uploads/2016/03/amarillo_intenso_01.jpg', '2012-01-24'),
                    ('52835839-799a-4986-ae42-6e84c9df4817', 'Conejo enano', 'Roedor', 'Oryctolagus cuniculus', 30, 0, 'https://animales.me/wp-content/uploads/2020/04/Conejo-enano-blanco.jpg', '2021-01-24'),
                    ('68a4a036-75a5-403d-b383-e4185403bf12', 'Serpiente de maíz', 'Reptil', 'Pantherophis guttatus', 35, 0, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSJzht2WVb5pxZUwbuZf20rorcucl8GV8_pCN02zIcmKUXT_9GDO5FtjkKVZwGYaqEYW_I&usqp=CAU', '2012-01-24'),
                    ('83adda81-fa43-4ea7-a8be-ddc61774552b', 'Pez betta', 'Pez', 'Betta splendens', 15, 0, 'https://www.acuarioplantado.com/21398-superlarge_default/betta-macho-selecto-n72.jpg', '2023-01-24'),
                    ('8bb13b7b-510c-4579-936f-96929c8afd2a', 'Periquito australiano', 'Ave', 'Melopsittacus undulatus', 22, 0, 'https://i.pinimg.com/736x/d2/91/b3/d291b36aef210d6dd4c2c11ebdaf7e01.jpg', '2021-01-24'),
                    ('9c4a4520-8987-4909-a106-5cc07c066d28', 'Cangrejo ermitaño', 'Crustáceo', 'Coenobita clypeatus', 12, 0, 'https://inaturalist-open-data.s3.amazonaws.com/photos/1317791/large.jpg', '2012-01-24'),
                    ('adc301e6-6378-41ab-9238-7c21e1a424e3', 'Gerbilo', 'Roedor', 'Meriones unguiculatus', 28, 0, 'https://www.wittemolen.com/sites/default/files/inline-images/gebril6.jpg', '2012-01-24'),
                    ('cc132455-2652-4f1e-8c3c-2031799aae74', 'Caimán de anteojos', 'Reptil', 'Caiman crocodilus', 75, 0, 'https://live.staticflickr.com/3029/2801070787_05c7e52f7d_c.jpg', '2023-01-24'),
                    ('cf51c708-08f4-4825-9b6c-1a56051f1239', 'Loro gris africano', 'Ave', 'Psittacus erithacus', 90, 0, 'https://upload.wikimedia.org/wikipedia/commons/thumb/b/ba/Psittacus_erithacus_qtl1.jpg/320px-Psittacus_erithacus_qtl1.jpg', '2012-01-24'),
                    ('d7990aa6-e4e3-4c97-bd32-a9f68c118d92', 'Conejo holandés', 'Roedor', 'Oryctolagus cuniculus', 35, 0, 'https://trofeocaza.com/wp-content/uploads/2016/08/Conejos-diferentes.jpg', '2021-01-24'),
                    ('de03e0b1-3c03-45e0-af2a-09c70577a064', 'Erizo pigmeo africano', 'Insectívoro', 'Atelerix albiventris', 45, 0, 'https://miwuki.com/wp-content/uploads/2016/05/shutterstock_163481378.jpg', '2023-01-24'),
                    ('e2d4695f-3474-4e53-8654-7c50bba8f071', 'Pececillo de colores', 'Pez', 'Carassius auratus', 15, 0, 'https://earimediaprodweb.azurewebsites.net/Api/v1/Multimedia/bd2d6304-667d-4fc6-b2b1-c37ff6b5174e/Rendition/low-res/Content/Public', '2023-01-24');";

            // Crear la conexión a MySQL
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                try
                {
                    // Abrir la conexión
                    connection.Open();

                    // Crear el comando SQL para insertar las mascotas de prueba
                    using (MySqlCommand command = new MySqlCommand(insertScript, connection))
                    {
                        // Ejecutar el script SQL
                        command.ExecuteNonQuery();
                        MessageManager.ShowMessage("Datos de prueba insertados", "Se han insertado las mascotas de prueba correctamente.");
                    }
                }
                catch (Exception ex)
                {
                    ErrorManager.Register(ex);
                }
            }
        }
<<<<<<< HEAD

=======
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// <summary>
        /// Crea un contenedor Docker para la base de datos MySQL.
        /// </summary>
        public static async Task CreateContainer()
        {
            using (var client = new DockerClientConfiguration(new Uri("npipe://./pipe/docker_engine")).CreateClient())
            {
                var createParameters = new CreateContainerParameters
                {
                    Name = Constants.CONTAINER_NAME,
                    Image = "mysql",
                    Env = new List<string> { "MYSQL_ROOT_PASSWORD=docker" },
                    HostConfig = new HostConfig
                    {
                        PortBindings = new Dictionary<string, IList<PortBinding>>
                        {
                            { "3306/tcp", new List<PortBinding> { new PortBinding { HostPort = "6969" } } }
                        },
                        Binds = new List<string> { "mysql:/var/lib/mysql" }
                    }
                };

                var container = await client.Containers.CreateContainerAsync(createParameters);
                await client.Containers.StartContainerAsync(container.ID, null);
            }
        }
    }
}
