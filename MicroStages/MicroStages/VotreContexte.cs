namespace MicroStages
{
    using Microsoft.EntityFrameworkCore;
    using MicroStages.Model;

    public class VotreContexte : DbContext
    {
        public VotreContexte(DbContextOptions<VotreContexte> options) : base(options)
        {
        }

     
        public DbSet<Internship> Internships { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {

        
        }
    
    }
}
