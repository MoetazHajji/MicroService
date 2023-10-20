using System.ComponentModel.DataAnnotations.Schema;

namespace MicroStages.Model
{
    public class Internship
    {
        public int Id { get; set; }
        public string Nom { get; set; }
        public string Prenom { get; set; }
        public string Subject { get; set; }
       
        public string University { get; set; }
        public string LocationUniversity { get; set; }
        public string PhoneUniversity { get; set; }
        public string LevelOfStudy { get; set; }
        public string Specialite { get; set; }
        public string Duration { get; set; }
        public string Motivation { get; set; }
        public string CV { get; set; }
        public State State { get; set; }

        
       
    }

}

