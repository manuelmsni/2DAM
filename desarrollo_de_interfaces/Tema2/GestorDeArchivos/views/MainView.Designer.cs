namespace GestorDeArchivos
{
    partial class MainView
    {
        /// <summary>
        ///  Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        ///  Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        ///  Required method for Designer support - do not modify
        ///  the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            menuStrip1 = new MenuStrip();
            toolStripMenuItem1 = new ToolStripMenuItem();
            Open_Item = new ToolStripMenuItem();
            Save_Item = new ToolStripMenuItem();
            Delete_Item = new ToolStripMenuItem();
            newFileToolStripMenuItem = new ToolStripMenuItem();
            toolStripMenuItem2 = new ToolStripMenuItem();
            richTextBox1 = new RichTextBox();
            menuStrip1.SuspendLayout();
            SuspendLayout();
            // 
            // menuStrip1
            // 
            menuStrip1.Items.AddRange(new ToolStripItem[] { toolStripMenuItem1, toolStripMenuItem2 });
            menuStrip1.Location = new Point(0, 0);
            menuStrip1.Name = "menuStrip1";
            menuStrip1.Size = new Size(457, 24);
            menuStrip1.TabIndex = 0;
            menuStrip1.Text = "menuStrip1";
            // 
            // toolStripMenuItem1
            // 
            toolStripMenuItem1.DropDownItems.AddRange(new ToolStripItem[] { Open_Item, Save_Item, Delete_Item, newFileToolStripMenuItem });
            toolStripMenuItem1.Name = "toolStripMenuItem1";
            toolStripMenuItem1.Size = new Size(37, 20);
            toolStripMenuItem1.Text = "File";
            // 
            // Open_Item
            // 
            Open_Item.Name = "Open_Item";
            Open_Item.Size = new Size(119, 22);
            Open_Item.Text = "Open";
            Open_Item.Click += Open_Item_Click;
            // 
            // Save_Item
            // 
            Save_Item.Name = "Save_Item";
            Save_Item.Size = new Size(119, 22);
            Save_Item.Text = "Save";
            Save_Item.Click += Save_Item_Click;
            // 
            // Delete_Item
            // 
            Delete_Item.Name = "Delete_Item";
            Delete_Item.Size = new Size(119, 22);
            Delete_Item.Text = "Delete";
            Delete_Item.Click += Delete_Item_Click;
            // 
            // newFileToolStripMenuItem
            // 
            newFileToolStripMenuItem.Name = "newFileToolStripMenuItem";
            newFileToolStripMenuItem.Size = new Size(119, 22);
            newFileToolStripMenuItem.Text = "New File";
            newFileToolStripMenuItem.Click += NewFile_Item_Click;
            // 
            // toolStripMenuItem2
            // 
            toolStripMenuItem2.Name = "toolStripMenuItem2";
            toolStripMenuItem2.Size = new Size(52, 20);
            toolStripMenuItem2.Text = "About";
            toolStripMenuItem2.Click += About_Click;
            // 
            // richTextBox1
            // 
            richTextBox1.Dock = DockStyle.Fill;
            richTextBox1.Location = new Point(0, 24);
            richTextBox1.Name = "richTextBox1";
            richTextBox1.Size = new Size(457, 378);
            richTextBox1.TabIndex = 1;
            richTextBox1.Text = "";
            // 
            // MainView
            // 
            AutoScaleDimensions = new SizeF(7F, 15F);
            AutoScaleMode = AutoScaleMode.Font;
            ClientSize = new Size(457, 402);
            Controls.Add(richTextBox1);
            Controls.Add(menuStrip1);
            FormBorderStyle = FormBorderStyle.SizableToolWindow;
            MainMenuStrip = menuStrip1;
            Name = "MainView";
            StartPosition = FormStartPosition.CenterScreen;
            Text = "Nuevo archivo";
            FormClosing += MainView_FormClosing;
            menuStrip1.ResumeLayout(false);
            menuStrip1.PerformLayout();
            ResumeLayout(false);
            PerformLayout();
        }

        #endregion

        private MenuStrip menuStrip1;
        private ToolStripMenuItem toolStripMenuItem1;
        private ToolStripTextBox toolStripTextBox2;
        private ToolStripTextBox toolStripTextBox3;
        private ToolStripTextBox toolStripTextBox4;
        private ToolStripMenuItem toolStripMenuItem2;
        private ToolStripMenuItem Open_Item;
        private ToolStripMenuItem Save_Item;
        private ToolStripMenuItem Delete_Item;
        private RichTextBox richTextBox1;
        private ToolStripMenuItem newFileToolStripMenuItem;
    }
}