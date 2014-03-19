package com.github.yusukemac.MoreTools;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

/**
 * 新しい鉱石(プラスチック鉱石)を生成します。
 * 最高y 64
 * 
 * 正直ココらへん理解してない
 * @author yusukemac
 */
public class OreGenerator implements IWorldGenerator
{

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider)
	{
		generateSurface(world, random, chunkX * 16, chunkZ * 16);
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		for (int k = 0; k < 10; k++)
		{
			int firstBlockXCoord = chunkX + random.nextInt(16);
			int firstBlockYCoord = random.nextInt(64);
			int firstBlockZCoord = chunkZ + random.nextInt(16);
			
			new WorldGenMinable(Core.orePlastic, 13).generate(world, random, firstBlockXCoord, firstBlockYCoord, firstBlockZCoord);
		}
		
	}
	

}
