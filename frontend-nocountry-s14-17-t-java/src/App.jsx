import { RouterProvider } from "react-router-dom";
import router from "./routes/router.jsx";
import { AuthProvider } from "./context/AuthProvider.jsx";

function App() {
  return (
    <AuthProvider>
      <RouterProvider router={router} />
    </AuthProvider>
  );
}

export default App;
