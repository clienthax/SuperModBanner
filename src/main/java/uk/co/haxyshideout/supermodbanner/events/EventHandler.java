package uk.co.haxyshideout.supermodbanner.events;

import com.pixelmonmod.pixelmon.api.events.RecievedModListEvent;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayerMP;
import uk.co.haxyshideout.supermodbanner.SuperModBanner;

import java.util.Arrays;

public class EventHandler {

	@SubscribeEvent
	public void onRecieveModList(RecievedModListEvent event)
	{
		if(SuperModBanner.config.whitelistedPlayers.contains(event.player.getDisplayName()))
			return;

		for(String modid : event.modIds)
		{
			if(SuperModBanner.config.bannedMods.contains(modid))
			{
				if(SuperModBanner.config.kickForBannedMods)
					((EntityPlayerMP)event.player).playerNetServerHandler.kickPlayerFromServer("This server does not allow "+modid);
				FMLLog.warning("Player "+event.player.getDisplayName()+" attempted to connect with banned mod "+modid);
			}
		}
		FMLLog.info("mods "+ Arrays.toString(event.modIds));
	}
}
