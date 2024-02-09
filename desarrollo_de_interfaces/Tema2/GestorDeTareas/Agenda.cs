using System;
using System.Collections.Generic;
using System.Linq;
using System.Numerics;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace GestorDeTareas
{
    public class Agenda
    {
        public List<Tarea> Tareas { get; }
        public Agenda()
        {
            Tareas = new List<Tarea>();
        }
        public bool AddTask(Tarea task)
        {
            if (Tareas.Contains(task)) return false;
            Tareas.Add(task);
            return false;
        }
        public Tarea? GetTaskById(int id)
        {
            foreach (var task in Tareas)
            {
                if (task.Id == id) return task;
            }
            return null;
        }
        private static void ListTasks(List<Tarea> tareas, string titulo)
        {
            if(tareas.Count == 0)
            {
                Console.WriteLine("\nNo hay tareas.");
                return;
            }
            Console.WriteLine(titulo);
            tareas.ForEach(task =>
            {
                Console.WriteLine(task.ToString());
            });
        }
        public void ListTasks()
        {
            Agenda.ListTasks(this.Tareas, "\nLista de tareas:");
        }
        public void ListUncompletedTask()
        {
            Agenda.ListTasks(this.Tareas.Where(tarea => !tarea.Completa).ToList(), "\nLista de tareas incompletas:");
        }
        public void listTasksShortedByExpirationDate()
        {
            Agenda.ListTasks(this.Tareas.OrderBy(task => task.Vencimiento).ToList(), "\nLista de tareas ordenadas por fecha de expiración:");
        }
    }
}
