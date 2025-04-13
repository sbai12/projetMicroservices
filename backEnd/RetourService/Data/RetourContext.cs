using Microsoft.EntityFrameworkCore;
using RetourService.Models;

namespace RetourService.Data
{
    public class RetourContext : DbContext
    {
        public RetourContext(DbContextOptions<RetourContext> options) : base(options)
        {
        }

        public DbSet<Retour> Retours { get; set; }
    }
}
