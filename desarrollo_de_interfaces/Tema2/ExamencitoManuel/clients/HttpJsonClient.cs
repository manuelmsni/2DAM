using ExamencitoManuel.models;
using ExamencitoManuel.utils;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http.Json;
using System.Text;
using System.Threading.Tasks;

namespace ExamencitoManuel.clients
{
    public class HttpJsonClient
    {
        public static async Task<string> PostMethod(string firstFile, string secondFile)
        {
            string data;
            Coincidence root = new Coincidence
            {
                contentFileOrigin = firstFile,
                contentFileOther = secondFile
            };
            // Simulamos una operación que lleva tiempo (por ejemplo, una solicitud HTTP)
            using (HttpClient httpClient = new HttpClient())
            {
                var result = await httpClient.PostAsJsonAsync($"{Constants.BASE_URL_API}{Constants.CUSTOM_PATH_API}", root);
                data = await result.Content.ReadAsStringAsync();
                Console.WriteLine(data);
            }
            return data;
        }
    }
    
}
