# AndroidToaster
A simple way to display Toast messages in Android without having to worry about them queueing up. 

## Usage
```
Toaster.getInstance(this).showShort("message");
```

A new Toast automatically cancels any currently visible Toasts.
