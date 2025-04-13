namespace RetourService.Models;

public class Retour
{
    public int Id { get; set; }
    
    // Utilisez 'required' pour indiquer que ces propriétés ne peuvent pas être nulles
    public required string ProduitNom { get; set; }  
    public required string MotifRetour { get; set; }  
    public required string Etat { get; set; }  

    public DateTime DateRetour { get; set; }

    // Si vous avez besoin d'initialiser certaines propriétés par défaut, vous pouvez le faire dans le constructeur ou ailleurs.
}
