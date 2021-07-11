package me.cosmic.superpickaxe;

import me.cosmic.superpickaxe.files.CustomConfig;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;


public class events implements Listener {
    BlockFace blockface = null;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_BLOCK)) {
            blockface = e.getBlockFace();
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        if (CustomConfig.get().getString("Particle").equalsIgnoreCase("default")) {
            if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
                String counte = CustomConfig.get().getString("ParticleCount");
                double count = Integer.parseInt(counte);
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(Utils.chat("&6Super Breaker"))) {
                    Player player = e.getPlayer();
                    double red = 0 / 255D;
                    double green = 0 / 255D;
                    double blue = 255 / 255D;
                    if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                        int x = block.getX();
                        int y = block.getY();
                        int z = block.getZ();
                        int Xmin = x - 1;
                        int Xmax = x + 2;
                        int Ymin = y - 1;
                        int Ymax = y + 2;
                        int Zmin = z - 1;
                        int Zmax = z + 2;


                        for (int i = Xmin; i < Xmax; i++) {

                            for (int j = Ymin; j < Ymax; j++) {

                                for (int k = Zmin; k < Zmax; k++) {
                                    Block newBlock = block.getWorld().getBlockAt(block.getX(), j, k);

                                    if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                        player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                        newBlock.setType(Material.AIR);
                                        e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                    }
                                }
                            }
                        }
                    }
                    if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                        int x = block.getX();
                        int y = block.getY();
                        int z = block.getZ();
                        int Xmin = x - 1;
                        int Xmax = x + 2;
                        int Ymin = y - 1;
                        int Ymax = y + 2;
                        int Zmin = z - 1;
                        int Zmax = z + 2;

                        for (int i = Xmin; i < Xmax; i++) {

                            for (int j = Ymin; j < Ymax; j++) {

                                for (int k = Zmin; k < Zmax; k++) {
                                    Block newBlock = block.getWorld().getBlockAt(i, j, block.getZ());
                                    if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                        player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                        newBlock.setType(Material.AIR);
                                        e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                    }

                                }
                            }
                        }
                    }
                    if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                        int x = block.getX();
                        int y = block.getY();
                        int z = block.getZ();
                        int Xmin = x - 1;
                        int Xmax = x + 2;
                        int Ymin = y - 1;
                        int Ymax = y + 2;
                        int Zmin = z - 1;
                        int Zmax = z + 2;

                        for (int i = Xmin; i < Xmax; i++) {

                            for (int j = Ymin; j < Ymax; j++) {

                                for (int k = Zmin; k < Zmax; k++) {
                                    Block newBlock = block.getWorld().getBlockAt(i, block.getY(), k);
                                    if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                        player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                        newBlock.setType(Material.AIR);
                                        e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                    }
                                }
                            }
                        }
                    }
                } else {
                    return;
                }

            } else{
                return;
            }
        } else {
            String particle = CustomConfig.get().getString("Particle");
            String counte = CustomConfig.get().getString("ParticleCount");
            double count = Integer.parseInt(counte);
            if (e.getPlayer().getInventory().getItemInMainHand().hasItemMeta()) {
                if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(Utils.chat("&6Super Breaker"))) {
                    /*if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                        Block block1 = block.getRelative(BlockFace.EAST);
                        Block block2 = block.getRelative(BlockFace.WEST);
                        Block block3 = block.getRelative(BlockFace.SOUTH);
                        Block block4 = block.getRelative(BlockFace.NORTH);
                        Block block5 = block.getRelative(BlockFace.NORTH_EAST);
                        Block block6 = block.getRelative(BlockFace.NORTH_WEST);
                        Block block7 = block.getRelative(BlockFace.SOUTH_EAST);
                        Block block8 = block.getRelative(BlockFace.SOUTH_WEST);
                        if (block1.getType().equals(Material.STONE) || block1.getType().equals(Material.COAL_ORE) || block1.getType().equals(Material.IRON_ORE) || block1.getType().equals(Material.DIAMOND_ORE) || block1.getType().equals(Material.PRISMARINE) || block1.getType().equals(Material.GOLD_ORE)) {
                            block1.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block1.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block2.getType().equals(Material.STONE) || block2.getType().equals(Material.COAL_ORE) || block2.getType().equals(Material.IRON_ORE) || block2.getType().equals(Material.DIAMOND_ORE) || block2.getType().equals(Material.PRISMARINE) || block2.getType().equals(Material.GOLD_ORE)) {
                            block2.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block2.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block3.getType().equals(Material.STONE) || block3.getType().equals(Material.COAL_ORE) || block3.getType().equals(Material.IRON_ORE) || block3.getType().equals(Material.DIAMOND_ORE) || block3.getType().equals(Material.PRISMARINE) || block3.getType().equals(Material.GOLD_ORE)) {
                            block3.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block3.getLocation(), (int) count, red, green, blue, 1);
                        }
                        if (block4.getType().equals(Material.STONE) || block4.getType().equals(Material.COAL_ORE) || block4.getType().equals(Material.IRON_ORE) || block4.getType().equals(Material.DIAMOND_ORE) || block4.getType().equals(Material.PRISMARINE) || block4.getType().equals(Material.GOLD_ORE)) {
                            block4.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block4.getLocation(), (int) count, red, green, blue, 1);


                        }
                        if (block5.getType().equals(Material.STONE) || block5.getType().equals(Material.COAL_ORE) || block5.getType().equals(Material.IRON_ORE) || block5.getType().equals(Material.DIAMOND_ORE) || block5.getType().equals(Material.PRISMARINE) || block5.getType().equals(Material.GOLD_ORE)) {
                            block5.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block5.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block6.getType().equals(Material.STONE) || block6.getType().equals(Material.COAL_ORE) || block6.getType().equals(Material.IRON_ORE) || block6.getType().equals(Material.DIAMOND_ORE) || block6.getType().equals(Material.PRISMARINE) || block6.getType().equals(Material.GOLD_ORE)) {
                            block6.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block6.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block7.getType().equals(Material.STONE) || block7.getType().equals(Material.COAL_ORE) || block7.getType().equals(Material.IRON_ORE) || block7.getType().equals(Material.DIAMOND_ORE) || block7.getType().equals(Material.PRISMARINE) || block7.getType().equals(Material.GOLD_ORE)) {
                            block7.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block7.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block8.getType().equals(Material.STONE) || block8.getType().equals(Material.COAL_ORE) || block8.getType().equals(Material.IRON_ORE) || block8.getType().equals(Material.DIAMOND_ORE) || block8.getType().equals(Material.PRISMARINE) || block8.getType().equals(Material.GOLD_ORE)) {
                            block8.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block8.getLocation(), (int) count, red, green, blue, 1);

                        }
                    }
                    if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                        Block block1 = block.getRelative(BlockFace.UP);
                        Block block2 = block.getRelative(BlockFace.DOWN);
                        Block block3 = block.getRelative(BlockFace.NORTH);
                        Block block4 = block.getRelative(BlockFace.SOUTH);
                        Block block5 = block1.getRelative(BlockFace.NORTH);
                        Block block6 = block1.getRelative(BlockFace.SOUTH);
                        Block block7 = block2.getRelative(BlockFace.NORTH);
                        Block block8 = block2.getRelative(BlockFace.SOUTH);
                        if (block1.getType().equals(Material.STONE) || block1.getType().equals(Material.COAL_ORE) || block1.getType().equals(Material.IRON_ORE) || block1.getType().equals(Material.DIAMOND_ORE) || block1.getType().equals(Material.PRISMARINE) || block1.getType().equals(Material.GOLD_ORE)) {
                            block1.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block1.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block2.getType().equals(Material.STONE) || block2.getType().equals(Material.COAL_ORE) || block2.getType().equals(Material.IRON_ORE) || block2.getType().equals(Material.DIAMOND_ORE) || block2.getType().equals(Material.PRISMARINE) || block2.getType().equals(Material.GOLD_ORE)) {
                            block2.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block2.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block3.getType().equals(Material.STONE) || block3.getType().equals(Material.COAL_ORE) || block3.getType().equals(Material.IRON_ORE) || block3.getType().equals(Material.DIAMOND_ORE) || block3.getType().equals(Material.PRISMARINE) || block3.getType().equals(Material.GOLD_ORE)) {
                            block3.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block3.getLocation(), (int) count, red, green, blue, 1);
                        }
                        if (block4.getType().equals(Material.STONE) || block4.getType().equals(Material.COAL_ORE) || block4.getType().equals(Material.IRON_ORE) || block4.getType().equals(Material.DIAMOND_ORE) || block4.getType().equals(Material.PRISMARINE) || block4.getType().equals(Material.GOLD_ORE)) {
                            block4.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block4.getLocation(), (int) count, red, green, blue, 1);


                        }
                        if (block5.getType().equals(Material.STONE) || block5.getType().equals(Material.COAL_ORE) || block5.getType().equals(Material.IRON_ORE) || block5.getType().equals(Material.DIAMOND_ORE) || block5.getType().equals(Material.PRISMARINE) || block5.getType().equals(Material.GOLD_ORE)) {
                            block5.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block5.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block6.getType().equals(Material.STONE) || block6.getType().equals(Material.COAL_ORE) || block6.getType().equals(Material.IRON_ORE) || block6.getType().equals(Material.DIAMOND_ORE) || block6.getType().equals(Material.PRISMARINE) || block6.getType().equals(Material.GOLD_ORE)) {
                            block6.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block6.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block7.getType().equals(Material.STONE) || block7.getType().equals(Material.COAL_ORE) || block7.getType().equals(Material.IRON_ORE) || block7.getType().equals(Material.DIAMOND_ORE) || block7.getType().equals(Material.PRISMARINE) || block7.getType().equals(Material.GOLD_ORE)) {
                            block7.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block7.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block8.getType().equals(Material.STONE) || block8.getType().equals(Material.COAL_ORE) || block8.getType().equals(Material.IRON_ORE) || block8.getType().equals(Material.DIAMOND_ORE) || block8.getType().equals(Material.PRISMARINE) || block8.getType().equals(Material.GOLD_ORE)) {
                            block8.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block8.getLocation(), (int) count, red, green, blue, 1);

                        }

                    }
                    if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                        Block block1 = block.getRelative(BlockFace.UP);
                        Block block2 = block.getRelative(BlockFace.DOWN);
                        Block block3 = block.getRelative(BlockFace.EAST);
                        Block block4 = block.getRelative(BlockFace.WEST);
                        Block block5 = block1.getRelative(BlockFace.EAST);
                        Block block6 = block1.getRelative(BlockFace.WEST);
                        Block block7 = block2.getRelative(BlockFace.EAST);
                        Block block8 = block2.getRelative(BlockFace.WEST);
                        if (block1.getType().equals(Material.STONE) || block1.getType().equals(Material.COAL_ORE) || block1.getType().equals(Material.IRON_ORE) || block1.getType().equals(Material.DIAMOND_ORE) || block1.getType().equals(Material.PRISMARINE) || block1.getType().equals(Material.GOLD_ORE)) {
                            block1.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block1.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block2.getType().equals(Material.STONE) || block2.getType().equals(Material.COAL_ORE) || block2.getType().equals(Material.IRON_ORE) || block2.getType().equals(Material.DIAMOND_ORE) || block2.getType().equals(Material.PRISMARINE) || block2.getType().equals(Material.GOLD_ORE)) {
                            block2.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block2.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block3.getType().equals(Material.STONE) || block3.getType().equals(Material.COAL_ORE) || block3.getType().equals(Material.IRON_ORE) || block3.getType().equals(Material.DIAMOND_ORE) || block3.getType().equals(Material.PRISMARINE) || block3.getType().equals(Material.GOLD_ORE)) {
                            block3.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block3.getLocation(), (int) count, red, green, blue, 1);
                        }
                        if (block4.getType().equals(Material.STONE) || block4.getType().equals(Material.COAL_ORE) || block4.getType().equals(Material.IRON_ORE) || block4.getType().equals(Material.DIAMOND_ORE) || block4.getType().equals(Material.PRISMARINE) || block4.getType().equals(Material.GOLD_ORE)) {
                            block4.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block4.getLocation(), (int) count, red, green, blue, 1);


                        }
                        if (block5.getType().equals(Material.STONE) || block5.getType().equals(Material.COAL_ORE) || block5.getType().equals(Material.IRON_ORE) || block5.getType().equals(Material.DIAMOND_ORE) || block5.getType().equals(Material.PRISMARINE) || block5.getType().equals(Material.GOLD_ORE)) {
                            block5.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block5.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block6.getType().equals(Material.STONE) || block6.getType().equals(Material.COAL_ORE) || block6.getType().equals(Material.IRON_ORE) || block6.getType().equals(Material.DIAMOND_ORE) || block6.getType().equals(Material.PRISMARINE) || block6.getType().equals(Material.GOLD_ORE)) {
                            block6.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block6.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block7.getType().equals(Material.STONE) || block7.getType().equals(Material.COAL_ORE) || block7.getType().equals(Material.IRON_ORE) || block7.getType().equals(Material.DIAMOND_ORE) || block7.getType().equals(Material.PRISMARINE) || block7.getType().equals(Material.GOLD_ORE)) {
                            block7.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block7.getLocation(), (int) count, red, green, blue, 1);

                        }
                        if (block8.getType().equals(Material.STONE) || block8.getType().equals(Material.COAL_ORE) || block8.getType().equals(Material.IRON_ORE) || block8.getType().equals(Material.DIAMOND_ORE) || block8.getType().equals(Material.PRISMARINE) || block8.getType().equals(Material.GOLD_ORE)) {
                            block8.setType(Material.AIR);
                            e.getPlayer().getInventory().addItem(block.getDrops().toArray(new ItemStack[0]));
                            double red = 0 / 255D;
                            double green = 0 / 255D;
                            double blue = 255 / 255D;
                            e.getPlayer().spawnParticle(Particle.valueOf(particle), block8.getLocation(), (int) count, red, green, blue, 1);

                        }

                    }
                }*/
                    Player player = e.getPlayer();
                    double red = 0 / 255D;
                    double green = 0 / 255D;
                    double blue = 255 / 255D;
                    if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                        int x = block.getX();
                        int y = block.getY();
                        int z = block.getZ();
                        int Xmin = x - 1;
                        int Xmax = x + 2;
                        int Ymin = y - 1;
                        int Ymax = y + 2;
                        int Zmin = z - 1;
                        int Zmax = z + 2;


                        for (int i = Xmin; i < Xmax; i++) {

                            for (int j = Ymin; j < Ymax; j++) {

                                for (int k = Zmin; k < Zmax; k++) {
                                    Block newBlock = block.getWorld().getBlockAt(block.getX(), j, k);
                                    if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                        player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                        newBlock.setType(Material.AIR);
                                        e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                    }
                                }
                            }
                        }
                    }
                    if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                        int x = block.getX();
                        int y = block.getY();
                        int z = block.getZ();
                        int Xmin = x - 1;
                        int Xmax = x + 2;
                        int Ymin = y - 1;
                        int Ymax = y + 2;
                        int Zmin = z - 1;
                        int Zmax = z + 2;

                        for (int i = Xmin; i < Xmax; i++) {

                            for (int j = Ymin; j < Ymax; j++) {

                                for (int k = Zmin; k < Zmax; k++) {
                                    Block newBlock = block.getWorld().getBlockAt(i, j, block.getZ());
                                    if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                        player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                        newBlock.setType(Material.AIR);
                                        e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                    }
                                }
                            }
                        }
                    }
                    if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                        int x = block.getX();
                        int y = block.getY();
                        int z = block.getZ();
                        int Xmin = x - 1;
                        int Xmax = x + 2;
                        int Ymin = y - 1;
                        int Ymax = y + 2;
                        int Zmin = z - 1;
                        int Zmax = z + 2;

                        for (int i = Xmin; i < Xmax; i++) {

                            for (int j = Ymin; j < Ymax; j++) {

                                for (int k = Zmin; k < Zmax; k++) {
                                    Block newBlock = block.getWorld().getBlockAt(i, block.getY(), k);
                                    if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                        player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                        newBlock.setType(Material.AIR);
                                        e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        if (CustomConfig.get().getString("Particle").equalsIgnoreCase("default")) {
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(Utils.chat("&6Shredder"))) {
                Player player = e.getPlayer();
                String counte = CustomConfig.get().getString("ParticleCount");
                double red = 0 / 255D;
                double green = 0 / 255D;
                double blue = 255 / 255D;
                double count = Integer.parseInt(counte);
                if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 2;
                    int Xmax = x + 3;
                    int Ymin = y - 2;
                    int Ymax = y + 3;
                    int Zmin = z - 2;
                    int Zmax = z + 3;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(block.getX(), j, k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 2;
                    int Xmax = x + 3;
                    int Ymin = y - 2;
                    int Ymax = y + 3;
                    int Zmin = z - 2;
                    int Zmax = z + 3;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, j, block.getZ());
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 2;
                    int Xmax = x + 3;
                    int Ymin = y - 2;
                    int Ymax = y + 3;
                    int Zmin = z - 2;
                    int Zmax = z + 3;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, block.getY(), k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(Utils.chat("&6Shredder"))) {
                Player player = e.getPlayer();
                String particle = CustomConfig.get().getString("Particle");
                String counte = CustomConfig.get().getString("ParticleCount");
                double red = 0 / 255D;
                double green = 0 / 255D;
                double blue = 255 / 255D;
                double count = Integer.parseInt(counte);
                if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 2;
                    int Xmax = x + 3;
                    int Ymin = y - 2;
                    int Ymax = y + 3;
                    int Zmin = z - 2;
                    int Zmax = z + 3;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(block.getX(), j, k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 2;
                    int Xmax = x + 3;
                    int Ymin = y - 2;
                    int Ymax = y + 3;
                    int Zmin = z - 2;
                    int Zmax = z + 3;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, j, block.getZ());
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 2;
                    int Xmax = x + 3;
                    int Ymin = y - 2;
                    int Ymax = y + 3;
                    int Zmin = z - 2;
                    int Zmax = z + 3;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, block.getY(), k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        if (CustomConfig.get().getString("Particle").equalsIgnoreCase("default")) {
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(Utils.chat("&dShredder v2"))) {
                Player player = e.getPlayer();
                String counte = CustomConfig.get().getString("ParticleCount");
                double red = 0 / 255D;
                double green = 0 / 255D;
                double blue = 255 / 255D;
                double count = Integer.parseInt(counte);
                if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 3;
                    int Xmax = x + 4;
                    int Ymin = y - 3;
                    int Ymax = y + 4;
                    int Zmin = z - 3;
                    int Zmax = z + 4;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(block.getX(), j, k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {
                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 3;
                    int Xmax = x + 4;
                    int Ymin = y - 3;
                    int Ymax = y + 4;
                    int Zmin = z - 3;
                    int Zmax = z + 4;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, j, block.getZ());
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 3;
                    int Xmax = x + 4;
                    int Ymin = y - 3;
                    int Ymax = y + 4;
                    int Zmin = z - 3;
                    int Zmax = z + 4;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, block.getY(), k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.FLAME, newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
        else{
            if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().contains(Utils.chat("&dShredder v2"))) {
                Player player = e.getPlayer();
                String particle = CustomConfig.get().getString("Particle");
                String counte = CustomConfig.get().getString("ParticleCount");
                double red = 0 / 255D;
                double green = 0 / 255D;
                double blue = 255 / 255D;
                double count = Integer.parseInt(counte);
                if (blockface.equals(BlockFace.EAST) || blockface.equals(BlockFace.WEST)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 3;
                    int Xmax = x + 4;
                    int Ymin = y - 3;
                    int Ymax = y + 4;
                    int Zmin = z - 3;
                    int Zmax = z + 4;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(block.getX(), j, k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.NORTH) || blockface.equals(BlockFace.SOUTH)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 3;
                    int Xmax = x + 4;
                    int Ymin = y - 3;
                    int Ymax = y + 4;
                    int Zmin = z - 3;
                    int Zmax = z + 4;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, j, block.getZ());
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
                if (blockface.equals(BlockFace.UP) || blockface.equals(BlockFace.DOWN)) {
                    int x = block.getX();
                    int y = block.getY();
                    int z = block.getZ();
                    int Xmin = x - 3;
                    int Xmax = x + 4;
                    int Ymin = y - 3;
                    int Ymax = y + 4;
                    int Zmin = z - 3;
                    int Zmax = z + 4;

                    for (int i = Xmin; i < Xmax; i++) {

                        for (int j = Ymin; j < Ymax; j++) {

                            for (int k = Zmin; k < Zmax; k++) {
                                Block newBlock = block.getWorld().getBlockAt(i, block.getY(), k);
                                if (newBlock.getType() == Material.STONE || newBlock.getType() == Material.COAL_ORE || newBlock.getType() == Material.IRON_ORE || newBlock.getType() == Material.DIAMOND_ORE || newBlock.getType() == Material.GOLD_ORE || newBlock.getType() == Material.PRISMARINE) {

                                    player.getInventory().addItem(new ItemStack(newBlock.getType()));
                                    newBlock.setType(Material.AIR);
                                    e.getPlayer().spawnParticle(Particle.valueOf(particle), newBlock.getLocation(), (int) count, red, green, blue, 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}




