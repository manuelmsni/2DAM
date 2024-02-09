using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Proyecto2Ev.Components
{
    /// <summary>
    /// Componente que hereda de Panel y contiene una etiqueta y un cuadro de texto.
    /// También gestiona un marcador de posición en el cuadro de texto.
    /// </summary>
    /// <seealso cref="System.Windows.Forms.Panel" />
    public class LabelledInput : Panel
    {
        private string LabelText { get; set; }
        private System.Windows.Forms.Label MainLabel { get; set; }
        public System.Windows.Forms.TextBox MainText { get; private set; }

        /// <summary>
        /// Inicializa una nueva instancia de la clase <see cref="LabelledInput"/>.
        /// </summary>
        /// <param name="labelText">El texto de la etiqueta.</param>
        /// <param name="placeHolder">El marcador de posición.</param>
        public LabelledInput(string labelText, string placeHolder)
        {
            LabelText = labelText;
            IniciarComponentes(placeHolder);
        }

        /// <summary>
        /// Inicializa los componentes.
        /// </summary>
        private void IniciarComponentes(string placeHolder)
        {
            this.MainLabel = new System.Windows.Forms.Label();
            this.MainText = new PlaceHolder(placeHolder);

            // 
            // MainPanel
            // 
            AutoSize = true;
            Controls.Add(this.MainLabel);
            Controls.Add(this.MainText);
            Dock = System.Windows.Forms.DockStyle.Top;
            Location = new System.Drawing.Point(0, 0);
            Name = $"MainPanel_{LabelText}";
            Size = new System.Drawing.Size(200, 26);
            TabIndex = 0;
            Padding = new System.Windows.Forms.Padding(3, 3, 6, 3);
            AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;

            // 
            // MainLabel
            // 
            this.MainLabel.AutoSize = true;
            this.MainLabel.Font = new System.Drawing.Font("Microsoft Sans Serif", 11.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.MainLabel.Location = new System.Drawing.Point(3, 4);
            this.MainLabel.Margin = new System.Windows.Forms.Padding(3, 4, 3, 4);
            this.MainLabel.Name = "MainLabel";
            this.MainLabel.Size = new System.Drawing.Size(46, 18);
            this.MainLabel.TabIndex = 0;
            this.MainLabel.Text = LabelText;

            // 
            // MainText
            // 
            this.MainText.Dock = DockStyle.Right;
        }
    }
}