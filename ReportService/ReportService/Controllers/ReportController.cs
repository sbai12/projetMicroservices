using Microsoft.AspNetCore.Mvc;
using OfficeOpenXml;
using System.IO;



namespace ReportService.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class ReportController : ControllerBase
    {
        
        // Point de terminaison pour générer un rapport
        [HttpGet("generate-report")]
        public IActionResult GenerateReport([FromQuery] string reportType)
        {
            if (reportType == "excel")
            {
                // Avant d'utiliser ExcelPackage, configure la licence
               ExcelPackage.LicenseContext = LicenseContext.NonCommercial;
                // Créer un fichier Excel

                var package = new ExcelPackage();
                var worksheet = package.Workbook.Worksheets.Add("Report");
                worksheet.Cells[1, 1].Value = "Exemple de données";
                worksheet.Cells[2, 1].Value = "Données supplémentaires";
                var file = new MemoryStream(package.GetAsByteArray());

                // Retourner le fichier Excel en tant que réponse HTTP
                return File(file, "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", "rapport.xlsx");
            }

            return BadRequest("Type de rapport non supporté.");
        }
    }
}
