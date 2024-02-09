using System.Text.RegularExpressions;

namespace GestorDeTareas
{
    class Progran
    {
        public static void Main()
        {
            Vista v = new Vista();
            Modelo m = new Modelo();
            Controlador c = new Controlador(v, m);
            v.Init(c);
        }

    }
}
