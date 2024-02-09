namespace ConversorDeDivisas
{
    public partial class Conversor : Form
    {
        public decimal? Quantity { get; set; }
        public Conversor()
        {
            InitializeComponent();
            InitCustom();
        }

        /* * * * * * * * * *
         *  Inicializaci�n * ------------------------------------------------------------------
         * * * * * * * * * */

        /// <summary>
        /// Llama a los m�todos que inician los componentes personalizados con los valores requeridos.
        /// </summary>
        public void InitCustom()
        {
            FetchCurrencies();
            Output_RichTextBox.Text = FileManager.ReadAll(Constants.OutputRegisterFile);
        }

        /// <summary>
        /// Carga los datos de las divisas.
        /// Si no hay divisas cierra el programa.
        /// Si hay divisas, llama al m�todo que las carga en un ComboBox.
        /// </summary>
        public void FetchCurrencies()
        {
            IEnumerable<Currency>? currencies = JsonManager<Currency>.GetCurrenciesFromJsonFile(Constants.CurrencyDataFile);
            if (currencies == null) Error.Fatal_Error(new Exception("No se han podido cargar los datos de las divisas, la aplicaci�n se cerrar�."));
            LoadOptions(Origin_ComboBox, currencies);
            LoadOptions(Destination_ComboBox, currencies);
        }

        /// <summary>
        /// Carga en las opciones de un ComboBox las divisas pasadas por par�metros.
        /// Este m�todo se llama cuando la selecci�n del ComboBox cambia.
        /// Asigna el valor seleccionado, casteandolo a Currency, a la variable global "Origin".
        /// </summary>
        /// <param name="combo">El ComboBox al cual se le a�adir�n las opciones.</param>
        /// <param name="currencies">Las divisas a introducir como opciones.</param>
        public void LoadOptions(ComboBox combo, IEnumerable<Currency> currencies)
        {
            foreach (var currency in currencies) combo.Items.Add(currency);
            if (combo.Items.Count > 0) combo.SelectedIndex = 0;
        }

        /* * * * * *
         * Eventos * ----------------------------------------------------------------------------
         * * * * * */

        /// <summary>
        /// Maneja el evento TextChanged del TextBox "DataOrigin".
        /// Este m�todo se llama cuando el contenido del TextBox cambia.
        /// Valida los datos introducidos, si no son v�lidos, el TextBox se vuelve rojo y el bot�n se desactiva.
        /// Si el TextBox est� vac�o, el bot�n se desactiva.
        /// </summary>
        /// <param name="sender">El objeto que desencaden� el evento, en este caso un TextBox.</param>
        /// <param name="e">Los argumentos del evento.</param>
        private void DataOrigin_TextChanged(object sender, EventArgs e)
        {
            TextBox input = sender as TextBox;
            string text = input.Text.Trim();
            if (decimal.TryParse(text, out decimal quantity))
            {
                Quantity = quantity;
                input.BackColor = Color.White;
                Submit_Button.Enabled = true;
            }
            else
            {
                if (text == String.Empty) input.BackColor = Color.White;
                else input.BackColor = Color.LightCoral;
                Submit_Button.Enabled = false;
            }
        }

        /// <summary>
        /// Maneja el evento de clic en el bot�n "Swap".
        /// Este m�todo intercambia los �ndices seleccionados en los ComboBox de origen y destino.
        /// </summary>
        /// <param name="sender">El objeto que desencaden� el evento, en este caso un bot�n.</param>
        /// <param name="e">Los argumentos del evento.</param>
        private void Swap_Button_Clicked(object sender, EventArgs e)
        {
            int buffer = Origin_ComboBox.SelectedIndex;
            Origin_ComboBox.SelectedIndex = Destination_ComboBox.SelectedIndex;
            Destination_ComboBox.SelectedIndex = buffer;
        }

        /// <summary>
        /// Maneja el evento de clic en el bot�n "Submit".
        /// Muestra en el RichTextBox la conversi�n de la moneda de origen a la moneda de destino.
        /// </summary>
        /// <param name="sender">El objeto que desencaden� el evento.</param>
        /// <param name="e">Los argumentos del evento.</param>
        private void Submit_Button_Clicked(object sender, MouseEventArgs e)
        {
            Currency Origin = (Currency) Origin_ComboBox.SelectedItem;
            Currency Destination = (Currency) Destination_ComboBox.SelectedItem;
            Output_RichTextBox.Text = $"  {DateTime.Now} [ Importe: {Quantity} {Origin.Symbol} => Cambio: {Math.Round(Calc.Conversion(Quantity, Origin.Factor, Destination.Factor) ?? 0, 2, MidpointRounding.ToZero)} {Destination.Symbol} ]{Environment.NewLine}{Output_RichTextBox.Text}";
        }

        /// <summary>
        /// Maneja el evento de cierre del formulario.
        /// Este m�todo se ejecuta cuando se intenta cerrar el formulario.
        /// Trata de guardar el historial de cambios en un archivo.
        /// Si no puede guardarlos pide confirmaci�n para cerrar.
        /// </summary>
        /// <param name="sender">El objeto que desencaden� el evento.</param>
        /// <param name="e">Los argumentos del evento de cierre del formulario.</param>
        private void Form_Close(object sender, FormClosingEventArgs e)
        {
            if (FileManager.Write(Output_RichTextBox.Text, Constants.OutputRegisterFile, false)) return;
            if (!Error.Ask_Confirmation(new Exception("�No se ha podido guardar el registro! �Est�s seguro de que deseas salir?"))) e.Cancel = true;
        }
    }
}