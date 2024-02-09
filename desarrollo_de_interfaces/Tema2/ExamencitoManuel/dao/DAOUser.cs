using ExamencitoManuel.models;
using ExamencitoManuel.utils;
using MySql.Data.MySqlClient;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ExamencitoManuel.dao
{
    internal class DAOUser : DAO<Usuario>
    {
        public List<Usuario> GetAll()
        {
            throw new NotImplementedException();
        }

        public bool InsertObject(Usuario obj)
        {
            throw new NotImplementedException();
        }

        public int SelectObject(Usuario u)
        {
            int result = 0;
            try
            {
                using (MySqlConnection conn = new MySqlConnection(Constants.CONNECTION_STRING))
                {
                    conn.Open();
                    MySqlCommand mySqlCommand = conn.CreateCommand();
                    mySqlCommand.CommandText = $"SELECT {Constants.COLUMN_FOR_ID} FROM {Constants.TABLE_NAME} WHERE {Constants.COLUMN_FOR_NAME} = @name AND {Constants.COLUMN_FOR_PASSWORD} = @pass";
                    mySqlCommand.Parameters.AddWithValue("@name", u.Name);
                    mySqlCommand.Parameters.AddWithValue("@pass", u.Pass);

                    using (MySqlDataReader reader = mySqlCommand.ExecuteReader())
                    {
                        if (reader.Read())
                        {
                            int temp = reader.GetInt32(0);
                            result = temp;
                            MessageManager.ShowMessaje("M",$"{temp}");
                        }
                    }
                }
            }
            catch (Exception ex)
            {
                ErrorManager.Register(ex);
            }
            return result;
        }

        public bool UpdateObject(Usuario obj)
        {
            throw new NotImplementedException();
        }

        Usuario DAO<Usuario>.SelectObject(int id)
        {
            throw new NotImplementedException();
        }
    }
}
