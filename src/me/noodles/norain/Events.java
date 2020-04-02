package me.noodles.norain;

import org.bukkit.event.*;

public class Events implements Listener
{
    
    @EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void WeatherChangeEvent(org.bukkit.event.weather.WeatherChangeEvent event) {
        if (!event.toWeatherState()) {
            return;
        }
            event.setCancelled(true);
            event.getWorld().setWeatherDuration(0);
            event.getWorld().setThundering(false);
        }
	
}
