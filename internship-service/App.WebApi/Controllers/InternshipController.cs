using System.Collections.Generic;
using App.ApplicationCore.Domain;
using App.WebApi.Settings;
using Microsoft.AspNetCore.Http;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Options;
using MongoDB.Driver;
using MongoDB.Driver.Core.Configuration;

namespace internship_service.Controllers
{
    [Route("biochar/internship-service/Internship")]
    [ApiController]
    public class InternshipController : ControllerBase
    {
        private readonly IMongoCollection<Internship> internshipCollection; 
        public InternshipController(IOptions<MongoDbSettings> mongoDbSettings)
        { 
            var connectionstring = $"mongodb://{mongoDbSettings.Value.Host}:{mongoDbSettings.Value.Port}/{mongoDbSettings.Value.DatabaseName}";
            var mongoUrl = MongoUrl.Create(connectionstring);
            var mongoClient = new MongoClient(mongoUrl);
            var database = mongoClient.GetDatabase(mongoUrl.DatabaseName);
            internshipCollection = database.GetCollection<Internship>("internship");



            /*var dbHost = "127.0.0.1";
            var dbName = "internshipDB"; 
            var connectionstring = $"mongodb://{dbHost}:27017/{dbName}";
            var mongoUrl = MongoUrl.Create(connectionstring);
            var mongoClient = new MongoClient(mongoUrl);
            var database = mongoClient.GetDatabase(mongoUrl.DatabaseName);
            _internshipCollection = database.GetCollection<Internship>("internship");*/ 
        }
        [HttpGet]
        //[Route("selectAll")]
        public async Task<ActionResult<IEnumerable<Internship>>> selectAll()
        {
            var internships = await internshipCollection.Find(Builders<Internship>.Filter.Empty).ToListAsync();
            if (internships == null || !internships.Any())
            {
                return NotFound(); // Return a 404 Not Found response.
            }
            return Ok(internships); // Return a 200 OK response with the internship data.
        }
        [HttpGet("{id}")]
        public async Task<ActionResult<Internship>> GetById(string id)
        {
            var filterDefinition = Builders<Internship>.Filter.Eq(x => x.Id, id);
            var internship = await internshipCollection.Find(filterDefinition).SingleOrDefaultAsync();
            if (internship == null)
            {
                return NotFound(); // Return a 404 Not Found response.
            }
            return Ok(internship); // Return a 200 OK response with the internship data.
        }
        [HttpPost]
        public async Task<IActionResult> insert([FromBody] Internship newInternship)
        {
            try
            {
                await internshipCollection.InsertOneAsync(newInternship);
                return Ok(); // Return a 200 OK response for a successful insertion.
            }
            catch (Exception ex)
            {
                return StatusCode(500, "An error occurred: " + ex.Message);
            }
        }
        [HttpPut("{id}")]
        public async Task<ActionResult> Update(string id, [FromBody] Internship internship)
        {
            if (string.IsNullOrEmpty(id))
            {
                return BadRequest("ID cannot be null or empty.");
            }

            var filterDefinition = Builders<Internship>.Filter.Eq(x => x.Id, id);
            var result = await internshipCollection.ReplaceOneAsync(filterDefinition, internship);
            
            if (result == null)
            {
                return NotFound(); // Return a 404 Not Found response.
            }
            return Ok(internship); // Return a 200 OK response with the internship data.
        }
        [HttpDelete("{id}")]
        public async Task<IActionResult> Delete(string id)
        {
            try
            {
                var filterDefinition = Builders<Internship>.Filter.Eq(x => x.Id, id);
                var result = await internshipCollection.DeleteOneAsync(filterDefinition);
                if (result.DeletedCount == 0)
                {
                    return NotFound();  // If no document was deleted, return a "Not Found" (HTTP 404) response.
                }
                return Ok(); // Return a 200 OK response for a successful deletion.
            }
            catch (Exception ex)
            {
                return StatusCode(500, "An error occurred: " + ex.Message);
            }
        }

        /*[HttpGet("selectByUsername/{username}")]
        public IActionResult selectByUsername(string username)
        {
            var internship = this.intershipService.Get(e => e.Username == username);
            if (internship == null)
            {
                return NotFound(); // Return a 404 Not Found response.
            }
            return Ok(internship); // Return a 200 OK response with the internship data.
        }
        [HttpPut("{id}")]
        public IActionResult update(long id, [FromBody] Internship updatedInternship)
        {
            var existingInternship = this.intershipService.GetById(id);
            if (existingInternship == null)
            {
                return NotFound(); // Return a 404 Not Found response.
            } 
            this.intershipService.Update(existingInternship);
            this.unitOfWork.Commit();
            return NoContent(); // Return a 204 No Content response to indicate success without a response body.
        }
        [HttpDelete("{id}")]
        public IActionResult delete(long id)
        {
            var internship = this.intershipService.GetById(id);
            if (internship == null)
            {
                return NotFound(); // Return a 404 Not Found response.
            }

            this.intershipService.Delete(internship);
            this.unitOfWork.Commit();
            return NoContent(); // Return a 204 No Content response to indicate success without a response body.
        }*/


    }
}
