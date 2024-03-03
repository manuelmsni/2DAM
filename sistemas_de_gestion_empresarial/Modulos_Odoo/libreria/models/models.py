from odoo import models, fields, api


class libreria_modelo(models.Model):
    _name = 'libreria.categoria'
    _description = 'libreria.categoria'
    name = fields.Char(string="Nombre", required=True, help="Nombre de la categoria")
    descripcion = fields.Text(string="Descripción", required=True, help="Descripción de la categoria")
    # Relación
    libros = fields.One2many("libreria.libro", "categoria", string="Libros")

class libreria_libro(models.Model):
    _name = 'libreria.libro'
    _description = 'libreria.libro'
    name = fields.Char(string="Titulo", required=True, help="Título del libro")
    descripcion = fields.Text(string="Descripción", required=True, help="Descripción de la categoria")
    ejemplares = fields.Integer(string="Ejemplares", required=True, help="Número de ejemplares")
    precio = fields.Float(string="Precio", required=True, help="Precio del libro")
    fecha = fields.Date(string="Fecha", help="Fecha de publicación")
    segmano = fields.Boolean(string="Segunda mano", help="Indica si el libro es de segunda mano")
    estado = fields.Selection([
        ('0', 'Nuevo'),
        ('1', 'Algo usado'),
        ('2', 'Descatalogado')
    ], string="Estado", default='0', help="Estado del libro")
    # Relación
    categoria = fields.Many2one("libreria.categoria", required=True, string="Categoria", ondelete="cascade")
    # Campo calcuado
    importeTotal = fields.Float(string="Importe Total", compute="_importetotal", store=True)
    @api.depends('precio','ejemplares')
    def _importetotal(self):
        for r in self: 
            r.importeTotal = r.ejemplares * r.precio


