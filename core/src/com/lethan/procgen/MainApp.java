package com.lethan.procgen;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.utils.Scaling;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScalingViewport;
import com.lethan.procgen.input.GestureHandler;
import com.lethan.procgen.input.InputHandler;

public class MainApp extends ApplicationAdapter {
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer;

	private GestureHandler gestureHandler;
	private InputHandler inputHandler;

	private ScalingViewport veiwport;
	private InputAdapter inputMultiplexer;

	private World world;

	@Override
	public void create () {
		camera = new OrthographicCamera();
		camera.setToOrtho(true, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		camera.update();

		veiwport = new ScalingViewport(Scaling.stretch, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		veiwport.setCamera(camera);

		shapeRenderer = new ShapeRenderer();

		gestureHandler = new GestureHandler(camera);
		inputHandler = new InputHandler(camera);

		InputMultiplexer inputMultiplexer = new InputMultiplexer();
		inputMultiplexer.addProcessor(inputHandler);
		inputMultiplexer.addProcessor(new GestureDetector(gestureHandler));
		Gdx.input.setInputProcessor(inputMultiplexer);

		world = new World();
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 1);

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
			shapeRenderer.setProjectionMatrix(camera.combined);
			shapeRenderer.setColor(Color.BLUE);
			world.render();
			shapeRenderer.end();
		camera.update();
	}
	
	@Override
	public void dispose () {
	}
}
