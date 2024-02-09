using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Text.Json;
using System.Threading;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace GestorDeTareas
{
    internal class Modelo
    {
        public Agenda AgendaTareas;
        public Modelo()
        {
            AgendaTareas = new Agenda();
        }
        public void ListarTareas()
        {
            AgendaTareas.ListTasks();
        }
        public void ListarTareasIncompletas()
        {
            AgendaTareas.ListUncompletedTask();
        }
        public void ListarTareasPorFechaDeVencimiento()
        {
            AgendaTareas.listTasksShortedByExpirationDate();
        }
        public bool AgregarNuevaTarea(Tarea tarea)
        {
            return AgendaTareas.AddTask(tarea);
        }
        public bool MarcarComoCompletada(Tarea tarea)
        {
            if (tarea.Completa) return false;
            tarea.Completa = true;
            return true;
        }
        async public void GuardarTareasEnJson(string rutaArchivo)
        {
            bool guardado = false;
            try {
                string json = JsonSerializer.Serialize(AgendaTareas.Tareas);
                File.WriteAllText(rutaArchivo, json);
                guardado = true;
            }  catch (Exception ex)
            {
                RegistrarError(ex);
            } finally
            {
                Console.WriteLine(guardado ? "Datos guardados correctamente." : "No se han podido guardar los datos.");
            }
        }
        async public void GuardarTareasEnXml(string rutaArchivo)
        {
            bool guardado = false;
            try
            {
                XmlSerializer xmlSerializer = new XmlSerializer(typeof(List<Tarea>));
                using (FileStream fileStream = new FileStream(rutaArchivo, FileMode.Create))
                {
                    xmlSerializer.Serialize(fileStream, AgendaTareas.Tareas);
                }
                guardado = true;
            } catch (Exception ex)
            {
                RegistrarError(ex);
            } finally
            {
                Console.WriteLine(guardado ? "Datos guardados correctamente." : "No se han podido guardar los datos.");
            }
        }
        public void CargarTareasDesdeJson(string rutaArchivo)
        {
            if (File.Exists(rutaArchivo))
            {
                string json = String.Empty;
                try
                {
                    json = File.ReadAllText(rutaArchivo);
                } catch (Exception ex)
                {
                    RegistrarError(ex);
                }
                if (json == String.Empty) return;
                List<Tarea> tareasCargadas = JsonSerializer.Deserialize<List<Tarea>>(json);
                int contador = 0;
                foreach (Tarea tarea in tareasCargadas)
                {
                    if (!AgendaTareas.Tareas.Contains(tarea))
                    {
                        AgendaTareas.Tareas.Add(tarea);
                        contador++;
                    }
                }
                Console.WriteLine($"{contador} Tareas cargadas.");
            }
        }
        public void CargarTareasDesdeXml(string rutaArchivo)
        {
            if (File.Exists(rutaArchivo))
            {
                try
                {
                    XmlSerializer xmlSerializer = new XmlSerializer(typeof(List<Tarea>));
                    using (FileStream fileStream = new FileStream(rutaArchivo, FileMode.Open))
                    {
                        List<Tarea> tareasCargadas = (List<Tarea>)xmlSerializer.Deserialize(fileStream);
                        int contador = 0;
                        foreach (Tarea tarea in tareasCargadas)
                        {
                            if (!AgendaTareas.Tareas.Contains(tarea))
                            {
                                AgendaTareas.Tareas.Add(tarea);
                                contador++;
                            }
                        }
                        Console.WriteLine($"{contador} Tareas cargadas.");
                    }
                }
                catch (Exception ex)
                {
                    RegistrarError(ex);
                }
            }
        }
        static void RegistrarError(Exception ex)
        {
            string logFilePath = Constantes.Logfile;
            string errorMessage = $"{DateTime.Now:yyyy-MM-dd HH:mm:ss} - Error: {ex.Message}\nStackTrace: {ex.StackTrace}\n";
            AppendEnArchivo(logFilePath, errorMessage);
        }
        async static void AppendEnArchivo(string path, string text)
        {
            try
            {
                File.AppendAllText(path, text);
                Console.WriteLine($"Error registrado en el archivo de registro '{Constantes.Logfile}'");
            }
            catch (IOException ioException)
            {
                Console.WriteLine($"Error al escribir en el archivo de registro: {ioException.Message}");
            }
        }
    }
}
