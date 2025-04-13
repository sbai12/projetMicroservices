using Microsoft.AspNetCore.Mvc;
using Microsoft.EntityFrameworkCore;
using RetourService.Data;
using RetourService.Models;

namespace RetourService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class RetourController : ControllerBase
    {
        private readonly RetourContext _context;

        public RetourController(RetourContext context)
        {
            _context = context;
        }

        // GET: api/Retour
        [HttpGet]
        public async Task<ActionResult<IEnumerable<Retour>>> GetRetours()
        {
            return await _context.Retours.ToListAsync();
        }

        // GET: api/Retour/5
        [HttpGet("{id}")]
        public async Task<ActionResult<Retour>> GetRetour(int id)
        {
            var retour = await _context.Retours.FindAsync(id);

            if (retour == null)
            {
                return NotFound();
            }

            return retour;
        }

        // POST: api/Retour
        [HttpPost]
        public async Task<ActionResult<Retour>> PostRetour(Retour retour)
        {
            _context.Retours.Add(retour);
            await _context.SaveChangesAsync();

            return CreatedAtAction("GetRetour", new { id = retour.Id }, retour);
        }

        // PUT: api/Retour/5
        [HttpPut("{id}")]
        public async Task<IActionResult> PutRetour(int id, Retour retour)
        {
            if (id != retour.Id)
            {
                return BadRequest();
            }

            _context.Entry(retour).State = EntityState.Modified;
            await _context.SaveChangesAsync();

            return NoContent();
        }

        // DELETE: api/Retour/5
        [HttpDelete("{id}")]
        public async Task<IActionResult> DeleteRetour(int id)
        {
            var retour = await _context.Retours.FindAsync(id);
            if (retour == null)
            {
                return NotFound();
            }

            _context.Retours.Remove(retour);
            await _context.SaveChangesAsync();

            return NoContent();
        }
    }
}
