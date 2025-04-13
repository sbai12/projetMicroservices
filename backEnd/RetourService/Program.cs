using Microsoft.EntityFrameworkCore;
using RetourService.Data;
using RetourService.Models;

var builder = WebApplication.CreateBuilder(args);

// Ajouter les services au conteneur

// Ajouter le DbContext pour utiliser SQL Server
builder.Services.AddDbContext<RetourContext>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("RetourConnection"))
);

// Ajouter les services pour les contrôleurs API
builder.Services.AddControllers();

// Swagger pour tester vos API, décommentez cette ligne
// builder.Services.AddEndpointsApiExplorer();
// builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configurer les middlewares
if (app.Environment.IsDevelopment())
{
    // Si l'environnement est en développement, activer la page d'exception de développement
    app.UseDeveloperExceptionPage();
    
    // Si vous souhaitez utiliser Swagger pour la documentation API, décommentez ces lignes
    // app.UseSwagger();
    // app.UseSwaggerUI();
}

app.UseHttpsRedirection();

// Utiliser les contrôleurs (les API seront mappées ici)
app.MapControllers();

app.Run();
