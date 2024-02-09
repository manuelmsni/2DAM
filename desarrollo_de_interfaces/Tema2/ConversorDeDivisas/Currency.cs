using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConversorDeDivisas
{
    public struct Currency
    {
        public string Name { get; set; }
        public decimal Factor { get; set; }
        public string Symbol { get; set; }
        public Currency(string name, decimal factor, string symbol) {
            this.Name = name;
            this.Factor = factor;
            this.Symbol = symbol;
        }
        public override string ToString() { return Name; }
    }
}
