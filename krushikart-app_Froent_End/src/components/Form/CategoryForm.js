// import React from "react";

// const CategoryForm = ({ handleSubmit, name, setName, desc, setDesc, status, setStatus, imgurl, setImgurl }) => {

    
//     return (
//         <>
//             <form onSubmit={handleSubmit}>
//                 <div className="mb-3">
//                     <input
//                         type="text"
//                         className="form-control"
//                         placeholder="Enter new category"
//                         value={name}
//                         onChange={(e) => setName(e.target.value)}
//                     />
//                 </div>
//                 <div className="mb-3">
//                     <textarea
//                         className="form-control"
//                         placeholder="Enter new categoryDesc"
//                         value={desc}
//                         onChange={(e) => setDesc(e.target.value)}
//                     />
//                 </div>

//                 <div className="mb-3">
//                     <div class="form-group">
//                         <label for="sel1">Acive Status</label>
//                         <select class="form-control" id="sel1 " value={status}
//                             onChange={(e) => setStatus(e.target.value)}>
//                             <option value={"true"}>True</option>
//                             <option value={"false"}>False</option>
//                         </select>
//                     </div>
//                 </div>

//                 <div className="mb-3">
//                     {/* <label htmlFor="formFile" className="form-label">Default file input example</label>
//                     <input className="form-control" type="file" id="formFile" value={imgurl}
//                         onChange={(e) => setImgurl(e.target.value)} /> */}





//                 </div>

//                 <button type="submit" className="btn btn-primary">
//                     Submit
//                 </button>
//             </form>
//         </>
//     );
// };

// export default CategoryForm;