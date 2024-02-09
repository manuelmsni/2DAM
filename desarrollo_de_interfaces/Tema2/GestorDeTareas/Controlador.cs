using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace GestorDeTareas
{
    internal class Controlador
    {
        Modelo M;
        Vista V;
        public Controlador(Vista v, Modelo m)
        {
            this.V = v;
            this.M = m;
        }
        public void performAction(int option)
        {
            switch (option)
            {
                case 1:
                    M.ListarTareas();
                    break;
                case 2:
                    M.ListarTareasIncompletas();
                    break;
                case 3:
                    M.ListarTareasPorFechaDeVencimiento();
                    break;
                case 4:
                    M.AgregarNuevaTarea(new Tarea(
                        V.AskForDate("Introduce fecha de vencimiento:"),
                        V.AskForString("Introduce una descripción:"),
                        V.AskForBool("¿Está completa?")
                     ));
                    break;
                case 5:
                    Tarea t;
                    M.ListarTareasIncompletas();
                    if (M.AgendaTareas.Tareas.Count == 0)
                    {
                        V.Log("No hay tareas gue mostrar.");
                        break;
                    }
                    while ((t = M.AgendaTareas.GetTaskById(V.AskForInt("Introduce el id de la tarea:"))) == null)
                    {
                        V.Log("No existe un contacto con ese id en la agenda");
                    }
                    M.MarcarComoCompletada(t);
                    break;
                case 6:
                    if (M.AgendaTareas.Tareas.Count == 0)
                    {
                        V.Log("No hay tareas gue guardar.");
                        break;
                    }
                    Guardar();
                    break;
                case 7:
                    Cargar();
                    break;
            }
        }
        public void Guardar()
        {
            V.Log("Guardando los datos de la agenda");
            switch (V.AskForIntRange("\nOpciones de guardado:\n 1- Guardar en JSON\n 2- Guardar en XML", 1, 2)){
                case 1:
                    M.GuardarTareasEnJson($"{DateTime.Now.ToString("yyyyMMdd")}_Download.json");
                    break;
                case 2:
                    M.GuardarTareasEnXml($"{DateTime.Now.ToString("yyyyMMdd")}_Download.xml");
                    break;
            }
        }
        public void Cargar()
        {
            V.Log("Cargando los datos de la agenda");
            string path = V.AskForFileWithExtension("Introduce el nombre del fichero", Constantes.ExtensionesPermitidas);
            if (path.EndsWith(".json"))
            {
                M.CargarTareasDesdeJson(path);
            } else if (path.EndsWith(".xml"))
            {
                M.CargarTareasDesdeXml(path);
            }
        }
    }
}
