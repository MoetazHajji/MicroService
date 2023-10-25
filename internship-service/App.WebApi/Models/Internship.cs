using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.ComponentModel.DataAnnotations.Schema;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using internship_service.Models;
using MongoDB.Bson;
using MongoDB.Bson.Serialization.Attributes;

namespace App.ApplicationCore.Domain
{
    [Serializable , BsonIgnoreExtraElements]//decorating 
    public class Internship
    {
        [BsonId , BsonElement("_id")] //decorate with bsum id attribute
        [BsonRepresentation(BsonType.String)]//this attribute automatically converts mongodata type to a.net type and vice versa 
        public string Id { get; set; } = String.Empty;
        [BsonElement("username")]
        public string Username { get; set; } = String.Empty;
        [BsonElement("nom")]
        public string Nom { get; set; } = String.Empty;
        [BsonElement("prenom")]
        public string Prenom { get; set; } = String.Empty;
        //public Status State { get; set; }
        //public Studylevel Studylevel  { get; set; }
        [BsonElement("subject")]
        public string Subject { get; set; } = String.Empty;
        [BsonElement("university")]
        public string University { get; set; } = String.Empty;
        //[MinLength(8)]
        //[MaxLength(8)]
        //[RegularExpression("[0-9]+")]
        //public string phone_university { get; set; }
        //public DateTime DateCreation { get; set; }

    }
}
