package net.imthebeemoplush.beemoboatsigns;

import net.imthebeemoplush.beemoboatsigns.renders.MaxSpeedSeawayMarkBigRenderer;
import net.imthebeemoplush.beemoboatsigns.renders.MaxSpeedSeawayMarkMediumRenderer;
import net.imthebeemoplush.beemoboatsigns.renders.MaxSpeedSeawayMarkSmallRenderer;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.util.thread.SidedThreadGroups;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.server.TickTask;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;

import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModTabs;
import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModMenus;
import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModItems;
import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModBlocks;
import net.imthebeemoplush.beemoboatsigns.init.BeemosBoatSignsModBlockEntities;

import java.util.function.Supplier;
import java.util.function.Function;
import java.util.function.BiConsumer;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Comparator;

import it.unimi.dsi.fastutil.ints.IntObjectPair;
import it.unimi.dsi.fastutil.ints.IntObjectImmutablePair;

@Mod("beemos_boat_signs")
public class BeemosBoatSignsMod {
	public static final Logger LOGGER = LogManager.getLogger(BeemosBoatSignsMod.class);
	public static final String MODID = "beemos_boat_signs";

	public BeemosBoatSignsMod(FMLJavaModLoadingContext context) {
		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = context.getModEventBus();
		BeemosBoatSignsModBlocks.REGISTRY.register(bus);
		BeemosBoatSignsModBlockEntities.REGISTRY.register(bus);
		BeemosBoatSignsModItems.REGISTRY.register(bus);
		BeemosBoatSignsModTabs.REGISTRY.register(bus);
		BeemosBoatSignsModMenus.REGISTRY.register(bus);

		if (net.minecraftforge.fml.loading.FMLEnvironment.dist == net.minecraftforge.api.distmarker.Dist.CLIENT) {
			bus.addListener(this::registerEntityRenderers);
		}
	}

	private void registerEntityRenderers(net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers event) {

		// MAX SPEED SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.MAX_SPEED_SEAWAY_MARK_SMALL.get(),
				MaxSpeedSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.MAX_SPEED_SEAWAY_MARK_MEDIUM.get(),
				MaxSpeedSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.MAX_SPEED_SEAWAY_MARK_BIG.get(),
				MaxSpeedSeawayMarkBigRenderer::new
		);

		// DISTANCE FROM MARK METERS SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_FROM_MARK_M_SEAWAY_MARK_SMALL.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceFromMarkMSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_FROM_MARK_M_SEAWAY_MARK_MEDIUM.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceFromMarkMSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_FROM_MARK_M_SEAWAY_MARK_BIG.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceFromMarkMSeawayMarkBigRenderer::new
		);

		// DISTANCE FROM MARK NAUTICAL MILES SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_SMALL.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceFromMarkNMSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_MEDIUM.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceFromMarkNMSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_FROM_MARK_NM_SEAWAY_MARK_BIG.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceFromMarkNMSeawayMarkBigRenderer::new
		);

		// DISTANCE TO SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_TO_SEAWAY_MARK_SMALL.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceToSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_TO_SEAWAY_MARK_MEDIUM.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceToSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.DISTANCE_TO_SEAWAY_MARK_BIG.get(),
				net.imthebeemoplush.beemoboatsigns.renders.DistanceToSeawayMarkBigRenderer::new
		);

		// RESTRICTED HEIGHT SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_HEIGHT_SEAWAY_MARK_SMALL.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedHeightSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_HEIGHT_SEAWAY_MARK_MEDIUM.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedHeightSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_HEIGHT_SEAWAY_MARK_BIG.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedHeightSeawayMarkBigRenderer::new
		);

		// RESTRICTED WIDTH SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_WIDTH_SEAWAY_MARK_SMALL.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedWidthSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_WIDTH_SEAWAY_MARK_MEDIUM.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedWidthSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_WIDTH_SEAWAY_MARK_BIG.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedWidthSeawayMarkBigRenderer::new
		);

		// RESTRICTED DEPTH SIGN
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_DEPTH_SEAWAY_MARK_SMALL.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedDepthSeawayMarkSmallRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_DEPTH_SEAWAY_MARK_MEDIUM.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedDepthSeawayMarkMediumRenderer::new
		);
		event.registerBlockEntityRenderer(
				BeemosBoatSignsModBlockEntities.RESTRICTED_DEPTH_SEAWAY_MARK_BIG.get(),
				net.imthebeemoplush.beemoboatsigns.renders.RestrictedDepthSeawayMarkBigRenderer::new
		);
	}

	private static final String PROTOCOL_VERSION = "1";
	public static final SimpleChannel PACKET_HANDLER = NetworkRegistry.newSimpleChannel(new ResourceLocation(MODID, MODID), () -> PROTOCOL_VERSION, PROTOCOL_VERSION::equals, PROTOCOL_VERSION::equals);
	private static int messageID = 0;

	public static <T> void addNetworkMessage(Class<T> messageType, BiConsumer<T, FriendlyByteBuf> encoder, Function<FriendlyByteBuf, T> decoder, BiConsumer<T, Supplier<NetworkEvent.Context>> messageConsumer) {
		PACKET_HANDLER.registerMessage(messageID, messageType, encoder, decoder, messageConsumer);
		messageID++;
	}

	private static final Queue<IntObjectPair<Runnable>> workToBeScheduled = new ConcurrentLinkedQueue<>();
	private static final PriorityQueue<TickTask> workQueue = new PriorityQueue<>(Comparator.comparingInt(TickTask::getTick));

	public static void queueServerWork(int delay, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workToBeScheduled.add(new IntObjectImmutablePair<>(delay, action));
	}

	@SubscribeEvent
	public void tick(TickEvent.ServerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			int currentTick = event.getServer().getTickCount();
			IntObjectPair<Runnable> work;
			while ((work = workToBeScheduled.poll()) != null) {
				workQueue.add(new TickTask(currentTick + work.leftInt(), work.right()));
			}
			while (!workQueue.isEmpty() && currentTick >= workQueue.peek().getTick()) {
				workQueue.poll().run();
			}
		}
	}
}