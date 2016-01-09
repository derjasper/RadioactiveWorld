package radioactiveworld;

import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.EventHandler;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class radioactiveListener implements Listener {
    radioactivePlugin plugin;
    public radioactiveListener(radioactivePlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
        this.plugin=plugin;
    }
    
    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) { // TODO anderes event ?
        if (plugin.getConfig().getList("worlds").contains(event.getPlayer().getWorld().getName()) && (!event.getPlayer().hasPermission("RadioactiveWorld.bypass") || !plugin.getConfig().getBoolean("permission"))) {
            if (event.getPlayer().getLocation().getBlock().getLightLevel()>=15 || ((event.getPlayer().getLocation().getBlock().getType()==Material.WATER||event.getPlayer().getLocation().getBlock().getType()==Material.STATIONARY_WATER) && event.getPlayer().getLocation().getBlock().getLightLevel()>=12)) {
                if (!(
                    event.getPlayer().getInventory().getHelmet()!=null && event.getPlayer().getInventory().getHelmet().getType()==Material.DIAMOND_HELMET && event.getPlayer().getInventory().getHelmet().getItemMeta().getDisplayName().equals(radioactivePlugin.radiationSuitHelmet) &&
                    event.getPlayer().getInventory().getChestplate()!=null && event.getPlayer().getInventory().getChestplate().getType()==Material.DIAMOND_CHESTPLATE && event.getPlayer().getInventory().getChestplate().getItemMeta().getDisplayName().equals(radioactivePlugin.radiationSuitChestplate) &&
                    event.getPlayer().getInventory().getLeggings()!=null && event.getPlayer().getInventory().getLeggings().getType()==Material.DIAMOND_LEGGINGS && event.getPlayer().getInventory().getLeggings().getItemMeta().getDisplayName().equals(radioactivePlugin.radiationSuitLeggings) &&
                    event.getPlayer().getInventory().getBoots()!=null && event.getPlayer().getInventory().getBoots().getType()==Material.DIAMOND_BOOTS && event.getPlayer().getInventory().getBoots().getItemMeta().getDisplayName().equals(radioactivePlugin.radiationSuitBoots)
                        )) {
                    event.getPlayer().damage(plugin.getConfig().getInt("playerdamage"));
                }
                else {
                    if (Math.random()<=plugin.getConfig().getDouble("armordamage")) {
                        event.getPlayer().getInventory().getHelmet().setDurability((short)(event.getPlayer().getInventory().getHelmet().getDurability()+1));
                        event.getPlayer().getInventory().getChestplate().setDurability((short)(event.getPlayer().getInventory().getChestplate().getDurability()+1));
                        event.getPlayer().getInventory().getLeggings().setDurability((short)(event.getPlayer().getInventory().getLeggings().getDurability()+1));
                        event.getPlayer().getInventory().getBoots().setDurability((short)(event.getPlayer().getInventory().getBoots().getDurability()+1));
                    }
                }
            }
        }
    }
    
    @EventHandler
    public void onCraftItem(CraftItemEvent event) {
        if (event.getRecipe() instanceof ShapelessRecipe) {
            if (!plugin.getConfig().getList("worlds").contains(event.getWhoClicked().getWorld().getName()) &&
                (
                ((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeHelmet.getIngredientList()) ||
                ((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeChestplate.getIngredientList()) ||
                ((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeLeggings.getIngredientList()) ||
                ((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeBoots.getIngredientList())
                    )) {
                event.setCancelled(true);
            }
        }
    }
    
    @EventHandler
    public void onPrepareItemCraft(PrepareItemCraftEvent event) {
        if (event.getRecipe() instanceof ShapelessRecipe) {

            if (((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeHelmet.getIngredientList())) {
                ItemStack is = radioactivePlugin.recipeHelmet.getResult().clone();
                ItemMeta im = plugin.getServer().getItemFactory().getItemMeta(Material.DIAMOND_HELMET);
                im.setDisplayName(radioactivePlugin.radiationSuitHelmet);
                is.setItemMeta(im);
                event.getInventory().setResult(is);
            }
            else if (((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeChestplate.getIngredientList())) {
                ItemStack is = radioactivePlugin.recipeChestplate.getResult().clone();
                ItemMeta im = plugin.getServer().getItemFactory().getItemMeta(Material.DIAMOND_CHESTPLATE);
                im.setDisplayName(radioactivePlugin.radiationSuitChestplate);
                is.setItemMeta(im);
                event.getInventory().setResult(is);
            }
            else if (((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeLeggings.getIngredientList())) {
                ItemStack is = radioactivePlugin.recipeLeggings.getResult().clone();
                ItemMeta im = plugin.getServer().getItemFactory().getItemMeta(Material.DIAMOND_LEGGINGS);
                im.setDisplayName(radioactivePlugin.radiationSuitLeggings);
                is.setItemMeta(im);
                event.getInventory().setResult(is);
            }
            else if (((ShapelessRecipe)event.getRecipe()).getIngredientList().equals(radioactivePlugin.recipeBoots.getIngredientList())) {
                ItemStack is = radioactivePlugin.recipeBoots.getResult().clone();
                ItemMeta im = plugin.getServer().getItemFactory().getItemMeta(Material.DIAMOND_BOOTS);
                im.setDisplayName(radioactivePlugin.radiationSuitBoots);
                is.setItemMeta(im);
                event.getInventory().setResult(is);
            }
        }
    }
}