// Generated by data binding compiler. Do not edit!
package com.emproto.pojo.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.emproto.pojo.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class CustomDialogTwoBinding extends ViewDataBinding {
  @NonNull
  public final Button buttonNext;

  @NonNull
  public final Button buttonPrevious;

  @NonNull
  public final TextView textViewContent;

  @NonNull
  public final TextView textViewTitle;

  protected CustomDialogTwoBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button buttonNext, Button buttonPrevious, TextView textViewContent, TextView textViewTitle) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonNext = buttonNext;
    this.buttonPrevious = buttonPrevious;
    this.textViewContent = textViewContent;
    this.textViewTitle = textViewTitle;
  }

  @NonNull
  public static CustomDialogTwoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.custom_dialog_two, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static CustomDialogTwoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<CustomDialogTwoBinding>inflateInternal(inflater, R.layout.custom_dialog_two, root, attachToRoot, component);
  }

  @NonNull
  public static CustomDialogTwoBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.custom_dialog_two, null, false, component)
   */
  @NonNull
  @Deprecated
  public static CustomDialogTwoBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<CustomDialogTwoBinding>inflateInternal(inflater, R.layout.custom_dialog_two, null, false, component);
  }

  public static CustomDialogTwoBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static CustomDialogTwoBinding bind(@NonNull View view, @Nullable Object component) {
    return (CustomDialogTwoBinding)bind(component, view, R.layout.custom_dialog_two);
  }
}