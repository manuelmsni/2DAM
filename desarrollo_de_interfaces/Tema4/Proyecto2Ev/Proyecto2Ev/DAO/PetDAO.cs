using MySql.Data.MySqlClient;
using Proyecto2Ev.Components;
using Proyecto2Ev.Models;
using Proyecto2Ev.Utils;
using System;
using System.Collections.Generic;
using System.Data.SqlClient;
using System.Globalization;
using System.IO;
using System.Linq;
using System.Management.Instrumentation;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2Ev.DAO
{
    /// <summary>
<<<<<<< HEAD
    /// Clase que maneja la persistencia y recuperación de datos de mascotas en la base de datos.
=======
    /// Clase que proporciona métodos para acceder y gestionar objetos de tipo 'Pet' en una base de datos.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    /// </summary>
    public class PetDAO : DAO<Pet>
    {
        /// <summary>
<<<<<<< HEAD
        /// Instancia única de la clase `PetDAO`.
        /// </summary>
        public static PetDAO Instance { get; private set; }

        /// <summary>
        /// Obtiene una instancia única de la clase `PetDAO`.
        /// </summary>
        /// <returns>Instancia única de la clase `PetDAO`.</returns>
=======
        /// Obtiene la instancia única de la clase 'PetDAO'.
        /// </summary>
        public static PetDAO Instance { get; private set;}
        /// <summary>
        /// Obtiene la instancia única de la clase 'PetDAO'.
        /// </summary>
        /// <returns>La instancia única de 'PetDAO'.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public static PetDAO GetInstance()
        {
            if (Instance == null) Instance = new PetDAO();
            return Instance;
        }
<<<<<<< HEAD

        /// <summary>
        /// Obtiene todas las mascotas almacenadas en la base de datos.
        /// </summary>
        /// <returns>Lista de mascotas almacenadas en la base de datos.</returns>
=======
        /// <summary>
        /// Constructor privado que inicializa una instancia de 'PetDAO'.
        /// </summary>
        private PetDAO(){}
        /// <summary>
        /// Obtiene todas las mascotas almacenadas en la base de datos.
        /// </summary>
        /// <returns>Una lista de todas las mascotas almacenadas en la base de datos.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public List<Pet> GetAll()
        {
            // Crea una lista para almacenar las mascotas recuperadas de la base de datos
            List<Pet> pets = new List<Pet>();
<<<<<<< HEAD

            // Abre una conexión a la base de datos
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                connection.Open();

                // Query SQL para seleccionar todas las mascotas de la tabla 'Pet'
                string query = "SELECT * FROM Pet";

                // Ejecuta la consulta SQL utilizando un lector de datos
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        // Lee los resultados de la consulta y crea instancias de mascotas
                        while (reader.Read())
                        {
                            Pet pet = new Pet
                            {
                                Id = Guid.Parse(reader[Constants.COLUMN_FOR_ID].ToString()),
                                Name = reader[Constants.COLUMN_FOR_NAME].ToString(),
                                Family = reader[Constants.COLUMN_FOR_FAMILY].ToString(),
                                Specie = reader[Constants.COLUMN_FOR_SPECIE].ToString(),
                                Price = Convert.ToInt32(reader[Constants.COLUMN_FOR_PRICE]),
                                Visited = Convert.ToInt32(reader[Constants.COLUMN_FOR_VISITED]),
                                Picture = reader[Constants.COLUMN_FOR_PICTURE].ToString(),
                                Age = DateTime.Parse(reader[Constants.COLUMN_FOR_BIRTH].ToString())
                            };

                            // Agrega la mascota a la lista
                            pets.Add(pet);
=======
            try
            {
                using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
                {
                    connection.Open();

                    string query = "SELECT * FROM Pet";
                    using (MySqlCommand command = new MySqlCommand(query, connection))
                    {
                        using (MySqlDataReader reader = command.ExecuteReader())
                        {
                            while (reader.Read())
                            {
                                Pet pet = new Pet
                                {
                                    Id = Guid.Parse(reader[Constants.COLUMN_FOR_ID].ToString()),
                                    Name = reader[Constants.COLUMN_FOR_NAME].ToString(),
                                    Family = reader[Constants.COLUMN_FOR_FAMILY].ToString(),
                                    Specie = reader[Constants.COLUMN_FOR_SPECIE].ToString(),
                                    Price = Convert.ToInt32(reader[Constants.COLUMN_FOR_PRICE]),
                                    Visited = Convert.ToInt32(reader[Constants.COLUMN_FOR_VISITED]),
                                    Picture = reader[Constants.COLUMN_FOR_PICTURE].ToString(),
                                    Age = DateTime.Parse(reader[Constants.COLUMN_FOR_BIRTH].ToString())
                                };

                                pets.Add(pet);
                            }
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
                        }
                    }
                }
            } catch (MySql.Data.MySqlClient.MySqlException e)
            {
                MessageManager.ShowAlert("Error", "No se pudo conectar con el servicio de la base de datos");
            }
            return pets;
        }
<<<<<<< HEAD

        /// <summary>
        /// Inserta una nueva mascota en la base de datos.
        /// </summary>
        /// <param name="obj">Mascota a ser insertada.</param>
        /// <returns>True si la inserción fue exitosa, False en caso contrario.</returns>
        public bool InsertObject(Pet obj)
        {
            // Abre una conexión a la base de datos
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                connection.Open();

                // Query SQL para insertar una nueva mascota en la tabla 'Pet'
                string query = "INSERT INTO Pet (" +
                               $"{Constants.COLUMN_FOR_ID}, " +
                               $"{Constants.COLUMN_FOR_NAME}, " +
                               $"{Constants.COLUMN_FOR_FAMILY}, " +
                               $"{Constants.COLUMN_FOR_SPECIE}, " +
                               $"{Constants.COLUMN_FOR_PRICE}, " +
                               $"{Constants.COLUMN_FOR_VISITED}," +
                               $"{Constants.COLUMN_FOR_PICTURE}," +
                               $"{Constants.COLUMN_FOR_BIRTH}" +
                               ") VALUES (@Id, @Name, @Family, @Specie, @Price, @Visited, @Picture, @Birth)";

                // Ejecuta la consulta SQL utilizando un comando preparado
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    // Establece los parámetros del comando con los valores de la mascota
                    command.Parameters.AddWithValue("@Id", obj.Id);
                    command.Parameters.AddWithValue("@Name", obj.Name);
                    command.Parameters.AddWithValue("@Family", obj.Family);
                    command.Parameters.AddWithValue("@Specie", obj.Specie);
                    command.Parameters.AddWithValue("@Price", obj.Price);
                    command.Parameters.AddWithValue("@Visited", 0);
                    command.Parameters.AddWithValue("@Picture", obj.Picture);
                    command.Parameters.AddWithValue("@Birth", obj.Age);

                    // Ejecuta el comando y obtiene el número de filas afectadas
                    int rowsAffected = command.ExecuteNonQuery();

                    // Retorna true si al menos una fila fue afectada (inserción exitosa)
                    return rowsAffected > 0;
=======
        /// <summary>
        /// Inserta una mascota en la base de datos.
        /// </summary>
        /// <param name="obj">La mascota a insertar.</param>
        /// <returns>true si se inserta correctamente, false en caso contrario.</returns>
        public bool InsertObject(Pet obj)
        {
            try {
                using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
                {
                    connection.Open();

                    string query = "INSERT INTO Pet (" +
                                   $"{Constants.COLUMN_FOR_ID}, " +
                                   $"{Constants.COLUMN_FOR_NAME}, " +
                                   $"{Constants.COLUMN_FOR_FAMILY}, " +
                                   $"{Constants.COLUMN_FOR_SPECIE}, " +
                                   $"{Constants.COLUMN_FOR_PRICE}, " +
                                   $"{Constants.COLUMN_FOR_VISITED}," +
                                   $"{Constants.COLUMN_FOR_PICTURE}," +
                                   $"{Constants.COLUMN_FOR_BIRTH}"+
                                   ") VALUES (@Id, @Name, @Family, @Specie, @Price, @Visited, @Picture, @Birth)";

                    using (MySqlCommand command = new MySqlCommand(query, connection))
                    {
                        command.Parameters.AddWithValue("@Id", obj.Id);
                        command.Parameters.AddWithValue("@Name", obj.Name);
                        command.Parameters.AddWithValue("@Family", obj.Family);
                        command.Parameters.AddWithValue("@Specie", obj.Specie);
                        command.Parameters.AddWithValue("@Price", obj.Price);
                        command.Parameters.AddWithValue("@Visited", obj.Visited);
                        command.Parameters.AddWithValue("@Picture", obj.Picture);
                        command.Parameters.AddWithValue("@Birth", obj.Age);

                        int rowsAffected = command.ExecuteNonQuery();

                        return rowsAffected > 0;
                    }
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
                }
            } catch (MySql.Data.MySqlClient.MySqlException e)
            {
                MessageManager.ShowAlert("Error", "No se pudo conectar con el servicio de la base de datos");
                return false;
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Elimina una mascota de la base de datos.
        /// </summary>
        /// <param name="obj">Mascota a ser eliminada.</param>
        /// <returns>True si la eliminación fue exitosa, False en caso contrario.</returns>
        public bool DeleteObject(Pet obj)
        {
            // Maneja casos donde el objeto o el ID no son válidos
=======
        /// <summary>
        /// Elimina una mascota de la base de datos.
        /// </summary>
        /// <param name="obj">La mascota a eliminar.</param>
        /// <returns>true si se elimina correctamente, false en caso contrario.</returns>
        public bool DeleteObject(Pet obj)
        {
            
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            if (obj == null)
            {
                return false;
            }
<<<<<<< HEAD

            // Abre una conexión a la base de datos
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                connection.Open();

                // Query SQL para eliminar la mascota con el ID proporcionado
                string query = $"DELETE FROM Pet WHERE {Constants.COLUMN_FOR_ID} = @Id";

                // Ejecuta la consulta SQL utilizando un comando preparado
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    // Establece el parámetro del comando con el valor del ID de la mascota
                    command.Parameters.AddWithValue("@Id", obj.Id);

                    // Ejecuta el comando y obtiene el número de filas afectadas
                    int rowsAffected = command.ExecuteNonQuery();

                    // Retorna true si al menos una fila fue afectada (eliminación exitosa)
                    return rowsAffected > 0;
=======
            try { 
                using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
                {
                    connection.Open();

                    string query = $"DELETE FROM Pet WHERE {Constants.COLUMN_FOR_ID} = @Id";

                    using (MySqlCommand command = new MySqlCommand(query, connection))
                    {
                        command.Parameters.AddWithValue("@Id", obj.Id);
                        int rowsAffected = command.ExecuteNonQuery();
                        return rowsAffected > 0;
                    }
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
                }
            } catch (MySql.Data.MySqlClient.MySqlException e)
            {
                MessageManager.ShowAlert("Error", "No se pudo conectar con el servicio de la base de datos");
                return false;
            }
        }
<<<<<<< HEAD

        /// <summary>
        /// Selecciona mascotas de la base de datos según los filtros proporcionados.
        /// </summary>
        /// <param name="filters">Diccionario de filtros y valores asociados.</param>
        /// <returns>Lista de mascotas que cumplen con los filtros.</returns>
        public List<Pet> SelectObjects(Dictionary<string, PlaceHolder> filters)
=======
        /// <summary>
        /// Realiza una búsqueda de mascotas en la base de datos utilizando filtros especificados.
        /// </summary>
        /// <param name="filters">Un diccionario de filtros con nombres de columnas y valores.</param>
        /// <returns>Una lista de mascotas que coinciden con los filtros.</returns>
        public List<Pet> SelectObjects(Dictionary<string,PlaceHolder> filters)
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        {
            // Crea una lista para almacenar las mascotas seleccionadas
            List<Pet> pets = new List<Pet>();

            // Crea un diccionario para almacenar los parámetros validados
            Dictionary<string, string> validated = new Dictionary<string, string>();

            // Indica si ya se ha aplicado el operador WHERE en la consulta SQL
            bool where = false;

            // Query SQL inicial sin filtros
            string query = "SELECT * FROM Pet";
<<<<<<< HEAD

            // Itera a través de los filtros proporcionados
            foreach (KeyValuePair<string, PlaceHolder> item in filters)
            {
                // Obtiene el valor del filtro (conversión especial para el filtro de precio)
                string value = (item.Key == Constants.COLUMN_FOR_PRICE) ? (item.Value.GetDouble() ?? 0).ToString() : item.Value.GetString();

                // Omite filtros con valores nulos, vacíos o iguales a cero
                if (value == null || value == "" || value == "0") continue;

                // Agrega el operador WHERE al query SQL si aún no se ha agregado
                if (!where)
                {
                    query += " WHERE ";
                    where = true;
                }
                else
                {
                    query += " AND ";
                }

                // Agrega la condición del filtro al query SQL
                if (item.Key == Constants.COLUMN_FOR_PRICE)
                {
                    query += $"{item.Key} <= @{item.Key}";
                }
                else
                {
                    query += $"{item.Key} LIKE @{item.Key}";
                }

                // Agrega el parámetro validado al diccionario
                validated.Add($"@{item.Key}", value);
=======
            if(filters != null) { 
                foreach (KeyValuePair<string, PlaceHolder> item in filters)
                {

                    string value;
                    if (item.Key == Constants.COLUMN_FOR_PRICE)
                    {
                        value = (item.Value.GetDouble()??0).ToString();
                    } else
                    {
                        value = item.Value.GetString();
                    }

                    if (value == null || value == "" || value == "0")
                    {
                        MessageManager.ShowMessage("Información de la búsqueda", "No se aplicará en la búsqueda el campo \"" + item.Key + "\" porque no tiene un valor válido.");
                        continue;
                    }
                
                    if (!where)
                    {
                        query += " WHERE ";
                        where = true;
                    }
                    else
                    {
                        query += " AND ";
                    }
                    if (item.Key == Constants.COLUMN_FOR_PRICE)
                    {
                        query += $"{item.Key} <= @{item.Key}";
                    }
                    else
                    {
                        query += $"{item.Key} LIKE @{item.Key}";
                    }

                    validated.Add($"@{item.Key}", item.Value.GetString());

                }
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            }

            try
            {
                // Abre una conexión a la base de datos
                using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
                {
                    connection.Open();

                    // Ejecuta la consulta SQL utilizando un comando preparado
                    using (MySqlCommand command = new MySqlCommand(query, connection))
                    {
                        // Agrega los parámetros validados al comando
                        foreach (KeyValuePair<string, string> item in validated)
                        {
                            // Ajusta el valor del parámetro para el filtro de precio
                            if (item.Key == $"@{Constants.COLUMN_FOR_PRICE}")
                            {
                                command.Parameters.AddWithValue(item.Key, item.Value);
                            }
                            else
                            {
                                // Añade caracteres de comodín para la coincidencia parcial en filtros de texto
                                command.Parameters.AddWithValue(item.Key, $"%{item.Value}%");
                            }
                        }

                        // Ejecuta el comando y obtiene un lector de datos
                        using (MySqlDataReader reader = command.ExecuteReader())
                        {
                            // Lee los resultados de la consulta y crea instancias de mascotas
                            while (reader.Read())
                            {
                                // Obtiene el ID de la mascota como cadena
                                string temp = reader[Constants.COLUMN_FOR_ID].ToString();
                                Guid id;

                                // Intenta convertir la cadena del ID a un objeto Guid
                                if (Guid.TryParse(temp, out id))
                                {
                                    // Crea una instancia de mascota con los datos de la base de datos
                                    Pet pet = new Pet
                                    {
                                        Id = id,
                                        Name = reader[Constants.COLUMN_FOR_NAME]?.ToString(),
                                        Family = reader[Constants.COLUMN_FOR_FAMILY]?.ToString(),
                                        Specie = reader[Constants.COLUMN_FOR_SPECIE]?.ToString(),
                                        Price = reader[Constants.COLUMN_FOR_PRICE] != DBNull.Value
                                                    ? Convert.ToInt32(reader[Constants.COLUMN_FOR_PRICE])
                                                    : 0,
                                        Visited = reader[Constants.COLUMN_FOR_VISITED] != DBNull.Value
                                                    ? Convert.ToInt32(reader[Constants.COLUMN_FOR_VISITED])
                                                    : 0,
                                        Picture = reader[Constants.COLUMN_FOR_PICTURE]?.ToString(),
                                        Age = reader[Constants.COLUMN_FOR_BIRTH] != DBNull.Value
                                                    ? DateTime.Parse(reader[Constants.COLUMN_FOR_BIRTH].ToString())
                                                    : DateTime.Now
                                    };

                                    // Agrega la mascota a la lista
                                    pets.Add(pet);
                                }
                                else
                                {
                                    // Maneja el caso en que el ID no pueda ser parseado
                                }
                            }
                        }
                    }
                }
            }
            catch (MySql.Data.MySqlClient.MySqlException e)
            {
                // Muestra una alerta en caso de error de conexión con la base de datos
                MessageManager.ShowAlert("Error", "No se pudo conectar con el servicio de la base de datos");
            }

            // Retorna la lista de mascotas seleccionadas
            return pets;
        }
<<<<<<< HEAD

        /// <summary>
        /// Actualiza la información de una mascota en la base de datos.
        /// </summary>
        /// <param name="obj">Mascota con la información actualizada.</param>
        /// <returns>True si la actualización fue exitosa, False en caso contrario.</returns>
=======
        /// <summary>
        /// Actualiza los datos de una mascota en la base de datos.
        /// </summary>
        /// <param name="obj">La mascota con los datos actualizados.</param>
        /// <returns>true si se actualiza correctamente, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public bool UpdateObject(Pet obj)
        {
            // Abre una conexión a la base de datos
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                connection.Open();

                // Query SQL para actualizar los datos de una mascota en la tabla 'Pet'
                string query = "UPDATE Pet SET " +
                               $"{Constants.COLUMN_FOR_NAME} = @Name, " +
                               $"{Constants.COLUMN_FOR_FAMILY} = @Family, " +
                               $"{Constants.COLUMN_FOR_SPECIE} = @Specie, " +
                               $"{Constants.COLUMN_FOR_PRICE} = @Price, " +
                               $"{Constants.COLUMN_FOR_PICTURE} = @Picture " +
                               "WHERE " +
                               $"{Constants.COLUMN_FOR_ID} = @Id";

                // Ejecuta la consulta SQL utilizando un comando preparado
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    // Establece los parámetros del comando con los valores actualizados de la mascota
                    command.Parameters.AddWithValue("@Name", obj.Name);
                    command.Parameters.AddWithValue("@Family", obj.Family);
                    command.Parameters.AddWithValue("@Specie", obj.Specie);
                    command.Parameters.AddWithValue("@Price", obj.Price);
                    command.Parameters.AddWithValue("@Picture", obj.Picture);
                    command.Parameters.AddWithValue("@Id", obj.Id.ToString());

                    // Ejecuta el comando y obtiene el número de filas afectadas
                    int rowsAffected = command.ExecuteNonQuery();

                    // Retorna true si al menos una fila fue afectada (actualización exitosa)
                    return rowsAffected > 0;
                }
            }
        }

        /// <summary>
<<<<<<< HEAD
        /// Selecciona una mascota de la base de datos según su ID.
        /// </summary>
        /// <param name="id">ID de la mascota a ser seleccionada.</param>
        /// <returns>Instancia de la mascota seleccionada, o null si no se encuentra.</returns>
=======
        /// Obtiene una mascota de la base de datos por su ID.
        /// </summary>
        /// <param name="id">El ID de la mascota.</param>
        /// <returns>La mascota encontrada o null si no se encuentra.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public Pet SelectObject(Guid id)
        {
            // Abre una conexión a la base de datos
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                connection.Open();

                // Query SQL para seleccionar una mascota según su ID
                string query = "SELECT * FROM Pet WHERE " +
                               $"{Constants.COLUMN_FOR_ID} = @Id";

                // Ejecuta la consulta SQL utilizando un comando preparado
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    // Establece el parámetro del comando con el valor del ID de la mascota
                    command.Parameters.AddWithValue("@Id", id);

                    // Ejecuta el comando y obtiene un lector de datos
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        // Lee los resultados de la consulta y crea una instancia de mascota
                        if (reader.Read())
                        {
                            Pet pet = new Pet
                            {
                                Id = Guid.Parse(reader[Constants.COLUMN_FOR_ID].ToString()),
                                Name = reader[Constants.COLUMN_FOR_NAME].ToString(),
                                Family = reader[Constants.COLUMN_FOR_FAMILY].ToString(),
                                Specie = reader[Constants.COLUMN_FOR_SPECIE].ToString(),
                                Price = Convert.ToInt32(reader[Constants.COLUMN_FOR_PRICE])
                            };

                            // Retorna la mascota seleccionada
                            return pet;
                        }
                    }
                }
            }

            // Retorna null si la mascota no fue encontrada
            return null;
        }
<<<<<<< HEAD

        /// <summary>
        /// Incrementa el contador de visitas de una mascota en la base de datos.
        /// </summary>
        /// <param name="data">Mascota cuyo contador de visitas será incrementado.</param>
        /// <returns>True si la actualización fue exitosa, False en caso contrario.</returns>
=======
        /// <summary>
        /// Incrementa el contador de visitas de una mascota en la base de datos.
        /// </summary>
        /// <param name="data">La mascota cuyo contador de visitas se incrementará.</param>
        /// <returns>true si se actualiza correctamente, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        public bool UpCount(Pet data)
        {
            try
            {
                // Abre una conexión a la base de datos
                using (MySqlConnection conn = new MySqlConnection())
                {
                    conn.ConnectionString = Constants.CONNECTION_STRING;
                    conn.Open();

                    // Crea un comando SQL para actualizar el contador de visitas de la mascota
                    MySqlCommand mySqlCommand = conn.CreateCommand();

                    // Incrementa el contador de visitas de la mascota y actualiza la base de datos
                    data.Visited++;
                    mySqlCommand.CommandText = $"UPDATE {Constants.TABLE_NAME} SET visited=@visited WHERE id=@id";
                    mySqlCommand.Parameters.AddWithValue("@id", data.Id);
                    mySqlCommand.Parameters.AddWithValue("@visited", data.Visited);

                    // Retorna true si al menos una fila fue afectada (actualización exitosa)
                    return mySqlCommand.ExecuteNonQuery() > 0;
                }
            }
            catch (Exception ex)
            {
                // Muestra un mensaje de error al usuario en caso de excepción
                ErrorManager.ShowToUser(ex);
            }

            // Retorna false en caso de error o falla en la actualización
            return false;
        }

        /// <summary>
<<<<<<< HEAD
        /// Obtiene las 10 mascotas más visitadas de la base de datos.
        /// </summary>
        /// <returns>Lista de las 10 mascotas más visitadas.</returns>
        public List<Pet> GetTopVisitedPets()
        {
            // Abre una conexión a la base de datos
=======
        /// Obtiene una lista de las mascotas más visitadas en la base de datos.
        /// </summary>
        /// <returns>Una lista de las mascotas más visitadas.</returns>
        public List<Pet> GetTopVisitedPets()
        {
            try {
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            using (MySqlConnection connection = new MySqlConnection(Constants.CONNECTION_STRING))
            {
                connection.Open();

                // Query SQL para seleccionar las 10 mascotas más visitadas
                string query = "SELECT * FROM Pet " +
                               $"ORDER BY {Constants.COLUMN_FOR_VISITED} DESC " +
                               "LIMIT 10";

                // Ejecuta la consulta SQL utilizando un comando preparado
                using (MySqlCommand command = new MySqlCommand(query, connection))
                {
                    // Obtiene un lector de datos para leer los resultados de la consulta
                    using (MySqlDataReader reader = command.ExecuteReader())
                    {
                        // Crea una lista para almacenar las mascotas más visitadas
                        List<Pet> topVisitedPets = new List<Pet>();

                        // Lee los resultados de la consulta y crea instancias de mascotas
                        while (reader.Read())
                        {
                            Pet pet = new Pet
                            {
                                Id = Guid.Parse(reader[Constants.COLUMN_FOR_ID].ToString()),
                                Name = reader[Constants.COLUMN_FOR_NAME].ToString(),
                                Family = reader[Constants.COLUMN_FOR_FAMILY].ToString(),
                                Specie = reader[Constants.COLUMN_FOR_SPECIE].ToString(),
                                Price = Convert.ToInt32(reader[Constants.COLUMN_FOR_PRICE]),
                                Visited = Convert.ToInt32(reader["visited"])
                            };

                            // Agrega la mascota a la lista
                            topVisitedPets.Add(pet);
                        }

                        // Retorna la lista de las 10 mascotas más visitadas
                        return topVisitedPets;
                    }
                }
            }
            } catch (MySql.Data.MySqlClient.MySqlException e)
            {
                MessageManager.ShowAlert("Error", "No se pudo conectar con el servicio de la base de datos");
                return null;
            }
        }

        /// <summary>
        /// Guarda una copia de seguridad de todas las mascotas en un archivo CSV.
        /// </summary>
        /// <param name="filePath">La ruta del archivo donde se guardará la copia de seguridad.</param>
        public void SaveBackupToCsv(string filePath)
        {
            List<Pet> pets = SelectObjects(null); // Utiliza el método existente para obtener todas las mascotas

            StringBuilder csvContent = new StringBuilder();
            // Agrega la cabecera con los nombres de las columnas
            csvContent.AppendLine("Id,Name,Family,Specie,Price,Visited,Picture,Age");

            foreach (var pet in pets)
            {
                // Convierte cada mascota a una línea de CSV
                string newLine = string.Format("\"{0}\",\"{1}\",\"{2}\",\"{3}\",\"{4}\",\"{5}\",\"{6}\",\"{7}\"",
                    pet.Id, pet.Name, pet.Family, pet.Specie, pet.Price, pet.Visited, pet.Picture, pet.Age.ToString("yyyy-MM-dd"));
                csvContent.AppendLine(newLine);
            }

            // Escribe el contenido CSV al archivo
            File.WriteAllText(filePath, csvContent.ToString());
        }

        /// <summary>
        /// Deserializa un archivo CSV y volca la información en la base de datos.
        /// </summary>
        /// <param name="filePath">La ruta del archivo CSV a deserializar.</param>
        public void LoadFromCsvToDatabase(string filePath)
        {
            var csvLines = File.ReadAllLines(filePath);
            for (int i = 1; i < csvLines.Length; i++)
            {
                var line = csvLines[i];
                var values = SplitCsvLine(line);

                try
                {
                    var pet = new Pet
                    {
                        Id = Guid.Parse(values[0]),
                        Name = values[1],
                        Family = values[2],
                        Specie = values[3],
                        Price = int.Parse(values[4]),
                        Visited = int.Parse(values[5]),
                        Picture = values[6],
                        Age = DateTime.ParseExact(values[7], "yyyy-MM-dd", CultureInfo.InvariantCulture)
                    };

                    if (!InsertObject(pet))
                    {
                        Console.WriteLine($"Error al insertar la mascota: {pet.Name}");
                    }
                }
                catch (FormatException ex)
                {
                    Console.WriteLine($"Error al procesar la línea {i}: {ex.Message}");
                }
            }
        }

        /// <summary>
        /// Descompone una línea de texto en formato CSV en sus componentes individuales, teniendo en cuenta las comillas que encierran valores con comas, espacios o saltos de línea.
        /// </summary>
        /// <param name="line">La línea de texto en formato CSV a descomponer.</param>
        /// <returns>Un array de strings, donde cada elemento representa un campo extraído de la línea CSV. Este método procesa correctamente los campos encerrados en comillas, permitiendo que los valores contengan comas, espacios o saltos de línea sin ser divididos erróneamente.</returns>
        /// <remarks>
        /// El método añade una coma al final de la línea de entrada para simplificar la lógica de detección del final de cada campo. Utiliza un enfoque basado en el estado para manejar correctamente las comillas dentro de los valores, alternando un estado de 'dentro de comillas' cada vez que encuentra un carácter de comilla doble no escapado. Esto permite extraer valores que están encerrados en comillas y que pueden contener comas, lo cual es una práctica común en archivos CSV para representar un solo campo de datos.
        /// </remarks>
        private string[] SplitCsvLine(string line)
        {
            var values = new List<string>();
            var columnIndex = 0;
            var inQuotes = false;
            var valueStart = 0;

            // Extiende la línea con una coma para facilitar la lógica de procesamiento
            line += ",";

            for (int i = 0; i < line.Length; i++)
            {
                if (line[i] == '"' && (i == 0 || line[i - 1] != '\\'))
                {
                    // Invertir el estado de inQuotes cuando encuentra una comilla que no está escapada
                    inQuotes = !inQuotes;
                }
                else if (line[i] == ',' && !inQuotes)
                {
                    // Agrega el valor a la lista cuando encuentra una coma fuera de las comillas
                    var value = line.Substring(valueStart, i - valueStart).Trim('"', ' ');
                    values.Add(value);
                    valueStart = i + 1; // Establece el inicio del próximo valor después de la coma
                }
            }

            return values.ToArray();
        }
    }
}
