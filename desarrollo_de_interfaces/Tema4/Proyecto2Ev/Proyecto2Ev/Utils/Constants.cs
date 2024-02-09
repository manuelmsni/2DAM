using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Proyecto2Ev.Utils
{
    public class Constants
    {
        public const string CONTAINER_NAME = "mysql_pets";
        // ----- Constantes de la base de datos -----
        public const string SERVER_STRING = "server=localhost;" +
                                                "port=6969;" +
                                                "uid=root;" +
                                                "pwd=docker;";

        public const string DATABASE_NAME = "pets";
        // string de conexión MySQL
        public const string CONNECTION_STRING = "server=localhost;" +
                                                "port=6969;" +
                                                "uid=root;" +
                                                "pwd=docker;" +
                                                "database=pets;";
        // nombres de las tablas
        public const string TABLE_NAME = "Pet";
        public const string COLUMN_FOR_ID = "id";
        public const string COLUMN_FOR_NAME = "name";
        public const string COLUMN_FOR_FAMILY = "family";
        public const string COLUMN_FOR_SPECIE = "specie";
        public const string COLUMN_FOR_PRICE = "price";
        public const string COLUMN_FOR_VISITED = "visited";
        public const string COLUMN_FOR_PICTURE = "picture";
        public const string COLUMN_FOR_BIRTH = "birth";

        // Filtros
        public static readonly Dictionary<string, string> FilterColumns = new Dictionary<string, string>
        {
            { "Nombre", Constants.COLUMN_FOR_NAME },
            { "Familia", Constants.COLUMN_FOR_FAMILY },
            { "Especie", Constants.COLUMN_FOR_SPECIE },
            { "Precio", Constants.COLUMN_FOR_PRICE }
        };

        // Other
        public const string ErrorLogFile = "Errors.log";
        public const string LOGO_PATH = "Assets/img/logoPezInvertido.png";

        // ----- Creación de la base de datos -----
        public const string CONTAINER_CREATION = "docker run --name mysql -v mysql:/var/lib/mysql -e MYSQL_ROOT_PASSWORD=docker -d -p 6969:3306 mysql";
        public const string USE_DATABASE = "USE Pet;";
        public const string DATABASE_CREATION = "CREATE DATABASE pets;";
        public const string TABLE_CREATION = "CREATE TABLE Pet(id CHAR(128) PRIMARY KEY, name CHAR(50), family CHAR(50), specie CHAR(50), price DOUBLE, visited INT , picture CHAR(250), birth DATE);";
    }
}
