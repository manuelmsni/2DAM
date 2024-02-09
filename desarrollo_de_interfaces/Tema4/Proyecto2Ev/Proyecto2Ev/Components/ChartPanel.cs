using Proyecto2Ev.DAO;
using System;
<<<<<<< HEAD
using System.Drawing;
=======
using System.Collections.Generic;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
using System.Windows.Forms;
using System.Windows.Forms.DataVisualization.Charting;

namespace Proyecto2Ev.Components
{
    /// <summary>
<<<<<<< HEAD
    /// Representa un Panel personalizado con un Gráfico incrustado y una etiqueta de título para mostrar datos.
    /// </summary>
    public class ChartPanel : Panel
    {
        private Chart Chart;
        private Label ChartTitle;
        private Series series;

        /// <summary>
        /// Inicializa una nueva instancia de la clase <see cref="ChartPanel"/>.
=======
    /// Clase que representa un panel con un gráfico de datos.
    /// </summary>
    public class ChartPanel : Panel
    {
        private System.Windows.Forms.DataVisualization.Charting.Series series;
        /// <summary>
        /// Constructor de la clase ChartPanel.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public ChartPanel()
        {
            rnd = new Random(); // Inicialización de Random
            usedColors = new HashSet<Color>(); // Inicialización de colores usados
            InitComponents();
        }
<<<<<<< HEAD

        /// <summary>
        /// Inicializa los componentes, incluido el Gráfico y la etiqueta de título.
=======
        /// <summary>
        /// Inicializa los componentes del panel de gráfico.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        private void InitComponents()
        {
            ChartArea chartArea1 = new ChartArea();
            Legend legend1 = new Legend();
            series = new Series();

            Chart = new Chart();
            ChartTitle = new Label();
            SuspendLayout();
            ((System.ComponentModel.ISupportInitialize)(Chart)).BeginInit();

            // ChartPanel configuration
            Controls.Add(Chart);
            Controls.Add(ChartTitle);
            Dock = DockStyle.Fill;
            Location = new Point(0, 0);
            Name = "ChartPanel";
            Size = new Size(992, 563);
            TabIndex = 0;

            // Chart configuration
            Chart.BorderlineColor = Color.Transparent;
            Chart.BackColor = Color.Transparent;
            chartArea1.Name = "ChartArea1";
<<<<<<< HEAD
            Chart.ChartAreas.Add(chartArea1);
            Chart.Dock = DockStyle.Fill;
=======
            chartArea1.BackColor = System.Drawing.Color.Transparent;
            this.Chart.ChartAreas.Add(chartArea1);
            this.Chart.Dock = System.Windows.Forms.DockStyle.Fill;
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
            legend1.Name = "Legend1";
            Chart.Legends.Add(legend1);
            Chart.Location = new Point(0, 24);
            Chart.Name = "Chart";
            series.ChartArea = "ChartArea1";
            series.Legend = "Legend1";
            series.Name = "Series1";
<<<<<<< HEAD
            Chart.Series.Add(series);
            Chart.Size = new Size(992, 539);
            Chart.TabIndex = 0;
            Chart.Text = "chart1";

            // ChartTitle configuration
            ChartTitle.AutoSize = true;
            ChartTitle.Dock = DockStyle.Top;
            ChartTitle.Font = new Font("Microsoft Sans Serif", 14.25F, FontStyle.Regular, GraphicsUnit.Point, ((byte)(0)));
            ChartTitle.Location = new Point(0, 0);
            ChartTitle.Name = "ChartTitle";
            ChartTitle.Size = new Size(173, 24);
            ChartTitle.TabIndex = 0;
            ChartTitle.Text = "This is the chart title";

            // Adjusting the X and Y axis
            Chart.ChartAreas["ChartArea1"].AxisX.LabelStyle.Angle = -90;
            Chart.ChartAreas["ChartArea1"].AxisX.Interval = 1; // Ensure each label is shown
            Chart.ChartAreas["ChartArea1"].AxisY.IsStartedFromZero = true;
            Chart.ChartAreas["ChartArea1"].AxisY.Interval = 1; // Ensure each label is shown
            Chart.ChartAreas["ChartArea1"].AxisY.LabelStyle.Format = "0"; // Display Y axis values as integers
=======
            this.Chart.Series.Add(series);
            this.Chart.Size = new System.Drawing.Size(992, 539);
            this.Chart.TabIndex = 0;
            this.Chart.Text = "chart1";
            this.Chart.BorderlineColor = System.Drawing.Color.Transparent;
            this.Chart.BackColor = System.Drawing.Color.Transparent;


            // 
            // ChartTitle
            // 
            this.ChartTitle.AutoSize = true;
            this.ChartTitle.Dock = System.Windows.Forms.DockStyle.Top;
            this.ChartTitle.Font = new System.Drawing.Font("Microsoft Sans Serif", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.ChartTitle.Name = "ChartTitle";
            this.ChartTitle.Size = new System.Drawing.Size(173, 24);
            this.ChartTitle.TabIndex = 0;
            this.ChartTitle.Padding = new System.Windows.Forms.Padding(30, 30, 0, 10);

>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47

            ResumeLayout(false);
            PerformLayout();
            ((System.ComponentModel.ISupportInitialize)(Chart)).EndInit();
        }
<<<<<<< HEAD

        /// <summary>
        /// Establece los datos de las mascotas más visitadas y actualiza el gráfico en consecuencia.
=======
        /// <summary>
        /// Establece los datos del gráfico para mostrar las mascotas más visitadas.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        public void SetMostVisitedData()
        {
            ChartTitle.Text = "Mascotas más visitadas";
            series.Name = "Número de visitas";
<<<<<<< HEAD
            series.ChartType = SeriesChartType.Column; // Ensure it's a column chart for clarity
            series.IsXValueIndexed = true;
            Random random = new Random();

            PetDAO.GetInstance().GetTopVisitedPets().ForEach(pet =>
            {
                Color randomColor = Color.FromArgb(random.Next(256), random.Next(256), random.Next(256));
                DataPoint dataPoint = new DataPoint();
                dataPoint.SetValueXY(pet.Name, pet.Visited);
                dataPoint.Color = randomColor;
                series.Points.Add(dataPoint);
            });
        }
=======
            series.ChartType = SeriesChartType.Column;

            var topVisitedPets = PetDAO.GetInstance().GetTopVisitedPets();
            if (topVisitedPets == null) return;
            if(topVisitedPets.Count == 0) return; // Evitar gráficos vacíos
            series.Points.Clear(); // Limpiar puntos existentes para evitar duplicados

            foreach (var pet in topVisitedPets)
            {
                if(pet.Visited == 0) continue; // Evitar mascotas con 0 visitas
                var point = new DataPoint
                {
                    AxisLabel = pet.Name,
                    YValues = new double[] { pet.Visited },
                    Color = GenerateUniquePastelColor()
                };
                series.Points.Add(point);
            }

            Chart.Series.Clear(); // Limpiar series existentes antes de agregar la nueva
            Chart.Series.Add(series);

            // Configuraciones adicionales
            Chart.ChartAreas[0].AxisX.LabelStyle.Angle = -90;
            Chart.ChartAreas[0].AxisY.Interval = 1;
            Chart.ChartAreas[0].AxisX.Interval = 1;
        }
        /// <summary>
        /// Genera un color pastel aleatorio evitando que se repita.
        /// </summary>
        private Color GenerateUniquePastelColor()
        {
            Color color;
            do
            {
                // Intenta generar un color pastel que no se haya usado antes
                color = Color.FromArgb(
                    (rnd.Next(256) + 255) / 2, // R
                    (rnd.Next(256) + 255) / 2, // G
                    (rnd.Next(256) + 255) / 2  // B
                );
            } while (usedColors.Contains(color));

            usedColors.Add(color); // Marcar el color como usado
            // Generar un color pastel
            return color;
        }
        private System.Windows.Forms.DataVisualization.Charting.Chart Chart;
        private System.Windows.Forms.Label ChartTitle;
        private Random rnd; // Instancia de Random
        private HashSet<Color> usedColors; // Colores usados
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
    }
}
