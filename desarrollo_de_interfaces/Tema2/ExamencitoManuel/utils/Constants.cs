using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamencitoManuel.utils
{
    public class Constants
    {

        // API Constants
        public const string BASE_URL_API = "http://localhost:32768";
        public const string CUSTOM_PATH_API = "/LevenshteinDistance";

        // DATABASE Constants
        public const string CONNECTION_STRING = "server=localhost;" +
                                                "port=6942;" +
                                                "uid=root;" +
                                                "pwd=pass;" +
                                                "database=Turnitin;";

        public const string TABLE_NAME = " Usuario";
        public const string COLUMN_FOR_PASSWORD = "password";
        public const string COLUMN_FOR_NAME = "username";
        public const string COLUMN_FOR_ID = "user_id";

        // Other
        public const string ErrorLogFile = "Errors.log";
        public const string PathToDirectory = "files";
    }
}
