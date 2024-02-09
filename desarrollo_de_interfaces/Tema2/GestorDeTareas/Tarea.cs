using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Serialization;

namespace GestorDeTareas
{
    public class Tarea
    {
        static int TotalTaskNum = 0;
        [XmlAttribute] // Como no paso la id por parámetros en el constructor no se incluía en el xml, con esto se fuerza
        public int Id { get; set; }
        public DateTime Vencimiento { get; set; }
        public string Descripcion { get; set; }
        public bool Completa { get; set; }
        public Tarea(DateTime vencimiento, string descripcion, bool completa) {
            this.Id = ++TotalTaskNum;
            this.Vencimiento = vencimiento;
            this.Descripcion = descripcion;
            this.Completa = completa;
        }
        private Tarea() { }
        public override bool Equals(object obj)
        {
            if (obj is Tarea otraTarea)
            {
                return 
                    Id == otraTarea.Id &&
                    Vencimiento == otraTarea.Vencimiento &&
                    Descripcion == otraTarea.Descripcion &&
                    Completa == otraTarea.Completa;
            }
            return false;
        }
        public override int GetHashCode()
        {
            return Id.GetHashCode() ^ Descripcion.GetHashCode() ^ Descripcion.GetHashCode() ^ Completa.GetHashCode();
        }
        public string ToString()
        {
            return $"{{id={Id},completa={Completa},vencimiento={Vencimiento},descripcion={Descripcion}}}";
        }
    }
}
