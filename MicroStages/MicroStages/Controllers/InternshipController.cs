using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;

using MicroStages.Model;

namespace MicroStages.Controllers
{
    namespace MicroStages.Controllers
    {
        [ApiController]
        [Route("api/internships")]
        public class InternshipController : ControllerBase
        {
            private readonly VotreContexte _context; // Assurez-vous de remplacer YourDbContext par le nom de votre contexte de base de données

            public InternshipController(VotreContexte context)
            {
                _context = context;
            }

            // GET: api/Internships
            [HttpGet]
            public async Task<ActionResult<IEnumerable<Internship>>> GetInternships()
            {
                return await _context.Internships.ToListAsync();
            }

            // GET: api/Internships/5
            [HttpGet("{id}")]
            public async Task<ActionResult<Internship>> GetInternship(int id)
            {
                var internship = await _context.Internships.FindAsync(id);

                if (internship == null)
                {
                    return NotFound();
                }

                return internship;
            }

            // POST: api/Internships
            [HttpPost]
            public async Task<ActionResult<Internship>> PostInternship(Internship internship)
            {
                _context.Internships.Add(internship);
                await _context.SaveChangesAsync();

                return  internship ;
            }

            // PUT: api/Internships/5
            [HttpPut("{id}")]
            public async Task<IActionResult> PutInternship(int id, Internship internship)
            {
                if (id != internship.Id)
                {
                    return BadRequest();
                }

                _context.Entry(internship).State = EntityState.Modified;

                try
                {
                    await _context.SaveChangesAsync();
                }
                catch (DbUpdateConcurrencyException)
                {
                    if (!InternshipExists(id))
                    {
                        return NotFound();
                    }
                    else
                    {
                        throw;
                    }
                }

                return NoContent();
            }

            // DELETE: api/Internships/5
            [HttpDelete("{id}")]
            public async Task<IActionResult> DeleteInternship(int id)
            {
                var internship = await _context.Internships.FindAsync(id);
                if (internship == null)
                {
                    return NotFound();
                }

                _context.Internships.Remove(internship);
                await _context.SaveChangesAsync();

                return NoContent();
            }

            private bool InternshipExists(int id)
            {
                return _context.Internships.Any(e => e.Id == id);
            }
        }
    }
}