using System.ComponentModel.DataAnnotations.Schema;

namespace MicroStages.Model
{
  
        public class Detail
        {
            public int Id { get; set; }
            public string University { get; set; }
            public string LocationUniversity { get; set; }
            public string PhoneUniversity { get; set; }
            public string LevelOfStudy { get; set; }
            public string Specialite { get; set; }

            
        }
    }

