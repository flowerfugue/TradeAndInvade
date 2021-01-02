package abigailfails.tradeandinvade;

import abigailfails.tradeandinvade.client.renderers.VillagerSleepyEyeRenderLayer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.VillagerRenderer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TradeAndInvade.MODID)
public class TradeAndInvade {
    
    public static final String MODID = "tradeandinvade";
    //private static final Logger LOGGER = LogManager.getLogger();

    public TradeAndInvade() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        Minecraft.getInstance().getRenderManager().renderers.values().forEach(renderer -> {
            if (renderer instanceof VillagerRenderer) {
                ((VillagerRenderer) renderer).addLayer(new VillagerSleepyEyeRenderLayer<>((VillagerRenderer)renderer));
            }
        });
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

   /*
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
    }*/
}
