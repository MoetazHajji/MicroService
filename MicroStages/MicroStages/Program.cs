using Microsoft.EntityFrameworkCore;
using MicroStages; // Assurez-vous que c'est le bon espace de noms
using MicroStages.Model;
using Microsoft.Extensions.Configuration; // Ajoutez cette directive using
using Microsoft.Extensions.DependencyInjection;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.Extensions.Hosting;

var builder = WebApplication.CreateBuilder(args);


// Ajoutez cette ligne dans la méthode ConfigureServices de votre application
builder.Services.AddControllers();



// Appel à AddDbContext pour configurer votre DbContext
builder.Services.AddDbContext<VotreContexte>(options =>
    options.UseSqlServer(builder.Configuration.GetConnectionString("VotreConnexion"))); // Utilisez builder.Configuration au lieu de Configuration

builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configurez votre application
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseAuthorization();

app.MapControllers();

app.Run();
