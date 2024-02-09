using System;
using System.Collections.Generic;

namespace Proyecto2Ev.DAO
{
    /// <summary>
<<<<<<< HEAD
    /// Interfaz genérica para operaciones CRUD (Crear, Leer, Actualizar, Eliminar) en una entidad específica.
    /// </summary>
    /// <typeparam name="T">Tipo de entidad que se manipulará.</typeparam>
    public interface DAO<T> where T : class
    {
        /// <summary>
        /// Obtiene todos los objetos de la entidad.
=======
    /// Interfaz genérica para definir operaciones CRUD (Create, Read, Update, Delete) en una base de datos para una entidad específica.
    /// </summary>
    /// <typeparam name="T">El tipo de entidad con la que se trabajará.</typeparam>
    public interface DAO<T> where T : class
    {
        /// <summary>
        /// Obtiene una lista de todos los objetos de la entidad desde la base de datos.
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        /// </summary>
        /// <returns>Una lista de objetos de la entidad.</returns>
        List<T> GetAll();

        /// <summary>
        /// Selecciona un objeto de la entidad por su identificador único.
        /// </summary>
<<<<<<< HEAD
        /// <param name="id">Identificador único del objeto.</param>
        /// <returns>El objeto de la entidad correspondiente al identificador único proporcionado.</returns>
        T SelectObject(Guid id);

        /// <summary>
        /// Inserta un nuevo objeto en la entidad.
        /// </summary>
        /// <param name="obj">Objeto a ser insertado.</param>
        /// <returns>Devuelve true si la operación de inserción fue exitosa, false en caso contrario.</returns>
        bool InsertObject(T obj);

        /// <summary>
        /// Actualiza un objeto existente en la entidad.
        /// </summary>
        /// <param name="obj">Objeto a ser actualizado.</param>
        /// <returns>Devuelve true si la operación de actualización fue exitosa, false en caso contrario.</returns>
=======
        /// <param name="id">El identificador único del objeto a seleccionar.</param>
        /// <returns>El objeto de la entidad seleccionado o null si no se encuentra.</returns>
        T SelectObject(Guid id);

        /// <summary>
        /// Inserta un objeto de la entidad en la base de datos.
        /// </summary>
        /// <param name="obj">El objeto de la entidad a insertar.</param>
        /// <returns>true si la inserción fue exitosa, false en caso contrario.</returns>
        bool InsertObject(T obj);

        /// <summary>
        /// Actualiza un objeto de la entidad en la base de datos.
        /// </summary>
        /// <param name="obj">El objeto de la entidad a actualizar.</param>
        /// <returns>true si la actualización fue exitosa, false en caso contrario.</returns>
>>>>>>> 0d91ccf407c86c284b607cf87d30bc68cba59c47
        bool UpdateObject(T obj);
    }
}