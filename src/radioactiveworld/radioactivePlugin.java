package radioactiveworld;
 
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.plugin.java.JavaPlugin;
 
public class radioactivePlugin extends JavaPlugin {
    radioactiveListener listener;
    static final Logger log = Logger.getLogger("Minecraft");
    
    // define names
    static final String radiationSuitHelmet=ChatColor.BLUE+"Radiation Helmet";
    static final String radiationSuitChestplate=ChatColor.BLUE+"Radiation Chestplate";
    static final String radiationSuitLeggings=ChatColor.BLUE+"Radiation Leggings";
    static final String radiationSuitBoots=ChatColor.BLUE+"Radiation Boots";
    
    static ShapelessRecipe recipeHelmet;
    static ShapelessRecipe recipeChestplate;
    static ShapelessRecipe recipeLeggings;
    static ShapelessRecipe recipeBoots;
        
    @Override
    public void onEnable(){
        // TODO acid rain (damage even if you've got armor)
        // TODO animals drop poisonous food
        // TODO areas with low/middle/high radiation
        // TODO different protection suits for different radiation strengh
        // TODO plants do not grow in the overworld
        
        // load config
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        // add crafting recipes
        ItemStack itemstackHelmet = new ItemStack(Material.DIAMOND_HELMET);
        recipeHelmet=new ShapelessRecipe(itemstackHelmet);
        recipeHelmet.addIngredient(1, Material.DIAMOND_HELMET).addIngredient(getConfig().getInt("armorcost"), Material.EMERALD); // TODO überall
        Bukkit.getServer().addRecipe(recipeHelmet);
        
        ItemStack itemstackChestplate = new ItemStack(Material.DIAMOND_CHESTPLATE);
        recipeChestplate=new ShapelessRecipe(itemstackChestplate);
        recipeChestplate.addIngredient(1, Material.DIAMOND_CHESTPLATE).addIngredient(getConfig().getInt("armorcost"), Material.EMERALD); 
        Bukkit.getServer().addRecipe(recipeChestplate);
        
        ItemStack itemstackLeggings = new ItemStack(Material.DIAMOND_LEGGINGS);
        recipeLeggings=new ShapelessRecipe(itemstackLeggings);
        recipeLeggings.addIngredient(1, Material.DIAMOND_LEGGINGS).addIngredient(getConfig().getInt("armorcost"), Material.EMERALD); 
        Bukkit.getServer().addRecipe(recipeLeggings);
        
        ItemStack itemstackBoots = new ItemStack(Material.DIAMOND_BOOTS);
        recipeBoots=new ShapelessRecipe(itemstackBoots);
        recipeBoots.addIngredient(1, Material.DIAMOND_BOOTS).addIngredient(getConfig().getInt("armorcost"), Material.EMERALD); 
        Bukkit.getServer().addRecipe(recipeBoots);
        
        // create listener
        listener = new radioactiveListener(this);
        
        log.info("RadioactiveWorld is enabled!");
    }
 
    @Override
    public void onDisable(){
        log.info("RadioactiveWorld is disabled!");
    }
}