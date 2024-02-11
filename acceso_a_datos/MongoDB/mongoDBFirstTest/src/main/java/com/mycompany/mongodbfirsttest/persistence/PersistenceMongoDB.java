package com.mycompany.mongodbfirsttest.persistence;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.model.Filters;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;

public class PersistenceMongoDB {

    private static final Logger log = Logger.getLogger(PersistenceMongoDB.class.getName());

    private String uri;
    private String database;
    private String collection;

    public PersistenceMongoDB(String uri, String database, String collection) {
        this.uri = uri;
        this.database = database;
        this.collection = collection;
    }

    public long cuentaDocumentos() throws CantCountDocumentsException {
        try (MongoClient mc = MongoClients.create(uri)) {
            return mc.getDatabase(database).getCollection(collection).countDocuments();
        } catch (Exception e) {
            String errorMessage = "Error al contar documentos en la colección " + collection + ": " + e.getMessage();
            log.severe(errorMessage);
            throw new CantCountDocumentsException(errorMessage, e);
        }
    }

    private List<Document> obtenDocumentos(Bson filter) throws CantGetDocumentsException {
        List<Document> documentos = new ArrayList<>();
        try (MongoClient mc = MongoClients.create(uri)) {
            var mongoCollection = mc.getDatabase(database).getCollection(collection);
            if (filter == null)
                mongoCollection.find().forEach(documentos::add);
            else
                mongoCollection.find(filter).forEach(documentos::add);
            return documentos;
        } catch (Exception e) {
            String errorMessage = "Error al obtener documentos de la colección " + collection + " con filtro " + filter + ": " + e.getMessage();
            log.severe(errorMessage);
            throw new CantGetDocumentsException(errorMessage, e);
        }
    }

    private Document obtenDocumentoFiltrando(Bson filter) throws CantGetDocumentFilteringException {
        try (MongoClient mc = MongoClients.create(uri)) {
            return mc.getDatabase(database).getCollection(collection).find(filter).first();
        } catch (Exception e) {
            String errorMessage = "Error al obtener un documento filtrando por " + filter + " en la colección " + collection + ": " + e.getMessage();
            log.severe(errorMessage);
            throw new CantGetDocumentFilteringException(errorMessage, e);
        }
    }

    private Bson creaFiltro(String campo, String valor) {
        if (campo.equals("_id")) {
            try {
                return Filters.eq(campo, new org.bson.types.ObjectId(valor));
            } catch (IllegalArgumentException e) {
                log.severe("El valor proporcionado para _id no es un ObjectId válido: " + valor);
                throw e;
            }
        } else {
            return Filters.eq(campo, valor);
        }
    }

    private Document creaDocumento(String[]... campos) {
        Document doc = new Document();
        for (String[] campo : campos) {
            if (campo.length != 2) continue;
            String clave = campo[0];
            String valor = campo[1];
            if (clave == null || valor == null) continue;
            if (clave.isBlank() || valor.isBlank()) continue;
            doc.append(clave, valor);
        }
        return doc;
    }

    public List<Document> obtenTodosLosDocumentos() throws CantGetDocumentsException {
        return obtenDocumentos(null);
    }

    public List<Document> obtenDocumentosFiltrando(String campo, String valor) throws CantGetDocumentsFilteringException {
        try {
            return obtenDocumentos(creaFiltro(campo, valor));
        } catch (CantGetDocumentsException e) {
            throw new CantGetDocumentsFilteringException("Error al obtener documentos filtrando por " + campo + "=" + valor, e);
        }
    }

    public Document obtenDocumentoPorCampo(String campo, String valor) throws CantGetDocumentFilteringException {
        return obtenDocumentoFiltrando(creaFiltro(campo, valor));
    }

    public Document obtenDocumentoPorId(String id) throws CantGetDocumentFilteringException {
        return obtenDocumentoFiltrando(creaFiltro("_id", id));
    }

    public String inserta(String[]... campos) throws CantInsertDocumentException {
        try (MongoClient mc = MongoClients.create(uri)) {
            Document doc = creaDocumento(campos);
            mc.getDatabase(database).getCollection(collection).insertOne(doc);
            return doc.get("_id").toString();
        } catch (Exception e) {
            String errorMessage = "Error al insertar un nuevo documento en la colección " + collection + ": " + e.getMessage();
            log.severe(errorMessage);
            throw new CantInsertDocumentException(errorMessage, e);
        }
    }

    public void eliminaPorId(String id) throws CantDeleteDocumentException {
        try (MongoClient mc = MongoClients.create(uri)) {
            var resultado = mc.getDatabase(database).getCollection(collection).deleteOne(creaFiltro("_id", id));
            if (resultado.getDeletedCount() == 0) {
                String warningMessage = "No se encontró el documento con ID " + id + " para eliminar.";
                log.warning(warningMessage);
                throw new DocumentNotFoundException(warningMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error al eliminar el documento con ID " + id + ": " + e.getMessage();
            log.severe(errorMessage);
            throw new CantDeleteDocumentException(errorMessage, e);
        }
    }

    public void actualizaPorId(String id, String[]... campos) throws CantUpdateDocumentException {
        Document doc = creaDocumento(campos);
        try (MongoClient mc = MongoClients.create(uri)) {
            var resultado = mc.getDatabase(database).getCollection(collection).replaceOne(creaFiltro("_id", id), doc);
            if (resultado.getModifiedCount() == 0) {
                String warningMessage = "No se pudo actualizar el documento con ID " + id;
                log.warning(warningMessage);
                throw new CantUpdateDocumentException(warningMessage);
            }
        } catch (Exception e) {
            String errorMessage = "Error al actualizar el documento con ID " + id + ": " + e.getMessage();
            log.severe(errorMessage);
            throw new CantUpdateDocumentException(errorMessage, e);
        }
    }


    public static class CantCountDocumentsException extends Exception {
        public CantCountDocumentsException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class CantGetDocumentsException extends Exception {
        public CantGetDocumentsException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class CantGetDocumentsFilteringException extends Exception {
        public CantGetDocumentsFilteringException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class CantGetDocumentFilteringException extends Exception {
        public CantGetDocumentFilteringException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class DocumentNotFoundException extends Exception {
        public DocumentNotFoundException(String message) {
            super(message);
        }
    }

    public static class CantInsertDocumentException extends Exception {
        public CantInsertDocumentException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class CantDeleteDocumentException extends Exception {
        public CantDeleteDocumentException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public static class CantUpdateDocumentException extends Exception {
        public CantUpdateDocumentException(String message) {
            super(message);
        }
        public CantUpdateDocumentException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}