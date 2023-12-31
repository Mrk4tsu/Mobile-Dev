// Generated by view binder compiler. Do not edit!
package com.ndthang.customizelistview.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.ndthang.customizelistview.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityDetailBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final CardView cardImage;

  @NonNull
  public final TextView detailDesc;

  @NonNull
  public final ImageView detailImage;

  @NonNull
  public final TextView detailIngredients;

  @NonNull
  public final TextView detailName;

  @NonNull
  public final TextView detailTime;

  private ActivityDetailBinding(@NonNull LinearLayout rootView, @NonNull CardView cardImage,
      @NonNull TextView detailDesc, @NonNull ImageView detailImage,
      @NonNull TextView detailIngredients, @NonNull TextView detailName,
      @NonNull TextView detailTime) {
    this.rootView = rootView;
    this.cardImage = cardImage;
    this.detailDesc = detailDesc;
    this.detailImage = detailImage;
    this.detailIngredients = detailIngredients;
    this.detailName = detailName;
    this.detailTime = detailTime;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityDetailBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_detail, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityDetailBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.cardImage;
      CardView cardImage = ViewBindings.findChildViewById(rootView, id);
      if (cardImage == null) {
        break missingId;
      }

      id = R.id.detailDesc;
      TextView detailDesc = ViewBindings.findChildViewById(rootView, id);
      if (detailDesc == null) {
        break missingId;
      }

      id = R.id.detailImage;
      ImageView detailImage = ViewBindings.findChildViewById(rootView, id);
      if (detailImage == null) {
        break missingId;
      }

      id = R.id.detailIngredients;
      TextView detailIngredients = ViewBindings.findChildViewById(rootView, id);
      if (detailIngredients == null) {
        break missingId;
      }

      id = R.id.detailName;
      TextView detailName = ViewBindings.findChildViewById(rootView, id);
      if (detailName == null) {
        break missingId;
      }

      id = R.id.detailTime;
      TextView detailTime = ViewBindings.findChildViewById(rootView, id);
      if (detailTime == null) {
        break missingId;
      }

      return new ActivityDetailBinding((LinearLayout) rootView, cardImage, detailDesc, detailImage,
          detailIngredients, detailName, detailTime);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
