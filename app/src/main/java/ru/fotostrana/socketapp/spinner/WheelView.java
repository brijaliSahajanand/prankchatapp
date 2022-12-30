package ru.fotostrana.socketapp.spinner;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

import androidx.annotation.Nullable;




import java.util.List;

import ru.fotostrana.socketapp.R;

public class WheelView extends View {
    @SuppressWarnings("FieldCanBeLocal")
    private final int DEFAULT_PADDING = 30, DEFAULT_ROTATION_COUNT = 30, DEFAULT_ROTATION_TIME = 5000;

    private int rotationTime = 0;
    private int rotationCount = 0;
    private RectF range = new RectF();
    private Paint archPaint;
    private int padding, radius, center, mWheelBackground;
    private List<WheelItem> mWheelItems;
    private OnLuckyWheelReachTheTarget mOnLuckyWheelReachTheTarget;

    //public static MediaPlayer mp;
    //    private Vibrator vibrator;
    private boolean doPlaySound = true;
    private int soundFile = R.raw.bicycle;

    public WheelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public WheelView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initComponents() {
        //arc paint object
        archPaint = new Paint();
        archPaint.setAntiAlias(true);
        archPaint.setDither(true);
        //rect rang of the arc
        range = new RectF(padding, padding, padding + radius, padding + radius);
       // mp = MediaPlayer.create(getContext(), soundFile);
//        vibrator = (Vibrator) getContext().getSystemService(Context.VIBRATOR_SERVICE);
    }


    private float getAngleOfIndexTarget(int target) {
        return (360 / mWheelItems.size()) * target;
    }

    public int getItemCount() {
        return mWheelItems.size();
    }

    public void setDoPlaySound(boolean doPlaySound) {
        this.doPlaySound = doPlaySound;
    }

    public void setSoundFile(int soundFile) {
        this.soundFile = soundFile;
        try {
          //  mp = MediaPlayer.create(getContext(), soundFile);
        } catch (Exception ignore) {
        }
    }

    public void setWheelBackgroundWheel(int wheelBackground) {
        mWheelBackground = wheelBackground;
        invalidate();
    }

    public void setWheelListener(OnLuckyWheelReachTheTarget onLuckyWheelReachTheTarget) {
        mOnLuckyWheelReachTheTarget = onLuckyWheelReachTheTarget;
    }

    public void setWheelRotationTime(int millisecond) {
        rotationTime = millisecond;
    }

    public void setWheelRotationNo(int count) {
        rotationCount = count;
    }


    public void addWheelItems(List<WheelItem> wheelItems) {
        mWheelItems = wheelItems;
        invalidate();
    }

    @SuppressWarnings("unused")
    private void drawWheelBackground(Canvas canvas) {
        Paint backgroundPainter = new Paint();
        backgroundPainter.setAntiAlias(true);
        backgroundPainter.setDither(true);
        backgroundPainter.setColor(mWheelBackground);
        canvas.drawCircle(center, center, center, backgroundPainter);
    }

    private void drawImage(Canvas canvas, float tempAngle, Bitmap bitmap, int pos) {
        //get every arc img width and angle
        int imgWidth = radius / mWheelItems.size();
        float angle = (float) ((tempAngle + 360 / mWheelItems.size() / 2) * Math.PI / 180);
        //calculate x and y
        int x = (int) (center + radius * 1.3 / 2 / 2 * Math.cos(angle));
        int y = (int) (center + radius * 1.3 / 2 / 2 * Math.sin(angle));
        //create arc to draw
        Rect rect;

        Float scale = 2.5f;
//        if (pos == 0 || pos == 3 || pos == 5 || pos == 7 || pos == 11) {
//            scale = 1.5f;
//        }/* else if (pos == 1) {
//            scale = 1.3f;
//        }*/ else


        rect = new Rect((int) (x - imgWidth / scale), (int) (y - imgWidth / scale), (int) (x + imgWidth / scale),
                (int) (y + imgWidth / scale));

        // rotate main bitmap
        Matrix matrix = new Matrix();
        matrix.postRotate(105 + (360 * pos / mWheelItems.size()));
        Bitmap rotatedBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        canvas.drawBitmap(rotatedBitmap, null, rect, null);
    }


    public void rotateWheelToTarget(int target, int winValue, boolean isLive,boolean ads) {

        float wheelItemCenter = 270 - getAngleOfIndexTarget(target) + (360 / mWheelItems.size()) / 2;
        animate().setInterpolator(new DecelerateInterpolator(1.5F))
                .setDuration(rotationTime == 0 ? DEFAULT_ROTATION_TIME : rotationTime)
                .rotation((360 * (rotationCount == 0 ? DEFAULT_ROTATION_COUNT : rotationCount)) + wheelItemCenter)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                        if (doPlaySound) {
                           /* if (mp != null) {
                                try {
                                    mp.seekTo(0);
                                } catch (Exception e) {
                                    Log.e("Exception", "seekTo", e);
                                }
                                if (mp != null) mp.start();
                            }*/
                        }
//                        vibrator.vibrate(500);
                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {
                        if (doPlaySound) {
                           /* if (mp != null) {
                                mp.pause();
                            }*/
                        }
                        if (mOnLuckyWheelReachTheTarget != null) {
                            mOnLuckyWheelReachTheTarget.onReachTarget(target, winValue, isLive,ads);
                        }
                        clearAnimation();
                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                })
                .start();
    }


    public void resetRotationLocationToZeroAngle(final int target, int winValue, boolean isLive,boolean ads) {
        animate().setDuration(0).rotation(0).setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                rotateWheelToTarget(target, winValue, isLive,ads);
                clearAnimation();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        drawWheelBackground(canvas);
        initComponents();

        float tempAngle = 0;
        float sweepAngle = 360 / mWheelItems.size();

        for (int i = 0; i < mWheelItems.size(); i++) {
            archPaint.setColor(mWheelItems.get(i).color);
            canvas.drawArc(range, tempAngle, sweepAngle, true, archPaint);
            drawImage(canvas, tempAngle, mWheelItems.get(i).bitmap, i);
            tempAngle += sweepAngle;
        }
//        Log.e("radius", "radius = " + radius);
//        Drawable d = getResources().getDrawable(R.drawable.spinner);
//        d.setBounds(0, 0, getWidth(), getWidth());
//        d.draw(canvas);

        float wheelItemCenter = 270 - getAngleOfIndexTarget(1) + (360 / mWheelItems.size());
        setRotation(wheelItemCenter);
    }

    @SuppressWarnings("SuspiciousNameCombination")
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int width = Math.min(getMeasuredWidth(), getMeasuredHeight());
        padding = getPaddingLeft() == 0 ? DEFAULT_PADDING : getPaddingLeft();
        radius = (width - padding * 2);
        center = width / 2;
        setMeasuredDimension(width, width);
    }
}